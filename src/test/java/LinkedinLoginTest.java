import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class LinkedinLoginTest {
    WebDriver driver;

    @BeforeMethod
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", "D:\\gooolech driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
    }

    @Test
    public void successfulLoginTest() {
        String initialPageTitle = driver.getTitle();
        String initialPageUrl = driver.getCurrentUrl();
        Assert.assertEquals(initialPageTitle, "Крупнейшая в мире сеть профессиональных контактов | LinkedIn", "Login page title is wrong");
        //WebElement emailField = driver.findElement(By.xpath("//*[@id='login-email']"));
        WebElement emailField = driver.findElement(By.id("login-email"));
        WebElement passwordField = driver.findElement(By.id("login-password"));
        WebElement signInButton = driver.findElement(By.id("login-submit"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        emailField.sendKeys("ol2018@ukr.net");
        passwordField.sendKeys("0933386035");
        signInButton.click();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        WebElement element = driver.findElement(By.id("rightfooter-default_copyright"));
        Assert.assertTrue(element.isDisplayed(), "User Error");
/*
        WebElement userIcon = driver.findElement(By.id("profile-nav-item"));
        Assert.assertTrue(userIcon.isDisplayed(), "User icon was not displayed");

        Assert.assertNotEquals(driver.getTitle(), initialPageTitle,
                "Page title did not change after login");
        Assert.assertNotEquals(driver.getCurrentUrl(), initialPageUrl,
                "Page url did not change after login");
*/
    }

    @Test
    public void negativeLoginTest() {
        //WebElement emailField = driver.findElement(By.xpath("//*[@id='login-email']"));
        WebElement emailField = driver.findElement(By.id("login-email"));
        WebElement passwordField = driver.findElement(By.id("login-password"));
        WebElement signInButton = driver.findElement(By.id("login-submit"));
      //  Assert.assertTrue(emailField.isDisplayed(), "EMail is not found.");
        emailField.sendKeys("test@ukr.net");
        passwordField.sendKeys("12345");
        signInButton.click();

        WebElement alertMessage = driver.findElement(By.xpath("//div[@id='global-alert-queue']//strong[not(text()='')]"));
        Assert.assertTrue(alertMessage.isDisplayed(), "Alert message is not displayed.");


    }


}