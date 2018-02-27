import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static java.lang.Thread.sleep;

public class LinkedinSearchTest {
    WebDriver driver;

    @BeforeMethod
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", "D:\\gooolech driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.linkedin.com/");
    }
/*
    @AfterMethod
    public void afterTest() {
        driver.close();
    }
*/
    @Test
    public void basicSearchTest() throws InterruptedException {
        LinkedinLoginPage loginPage = new LinkedinLoginPage(driver);
        loginPage.loginAs("ol2018@ukr.net", "0933386035");
        //search
        String searchTerm = "HR";
        driver.findElement(By.xpath("//input[@placeholder='Поиск']")).sendKeys(searchTerm);
        driver.findElement(By.xpath("//*[@type='search-icon']")).click();
        //[contains(@class,'search-result__occluded-item')]
        List<WebElement> results = driver.findElements(By.xpath("//li[contains(@class,'search-result__occluded-item')]"));
        int currentResultsNumber = results.size();
        Assert.assertEquals(results.size(), 10, "Number of results is wrong");
        for (int i = 1; i < results.size(); i++) {
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", results.get(i));
           String cardTitle = driver.findElement(By.xpath("//li[contains(@class,'search-result__occluded-item')]["+i+"]//span[contains(@class, 'actor-name')]")).getText();
           System.out.println(cardTitle+"  "+cardTitle.length());



            //Assert.assertTrue(cardTitle.contains(searchTerm.toLowerCase()), "Searchterm "+searchTerm+ "not found in cart number"+ Integer.toString(i));
            //cardTitle.indexOf(searchTerm)>-1?true:false
            //loginPage.waitUntilElementIsClickable(driver.findElement(By.xpath("//li[contains(@class,'search-result__occluded-item')]["+i+"]//span[contains(@class, 'actor-name')]")), 30);
        }

        //List<WebElement> cardTitles = driver.findElements(By.xpath("//li[contains(@class,'search-result__occluded-item')]//span[contains(@class, 'actor-name')]"));


        //input[@placeholder='Search']
        //*[@type='search-icon']
        //div[contains(@class,'search-result--person')]

    }
}