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
    public void afterTest() { driver.close(); }

    @Test
    public void successfulLoginTest() {
        LinkedinLoginPage loginPage = new LinkedinLoginPage(driver);
        String initialPageTitle = loginPage.getPageTitle();
        String initialPageUrl = loginPage.getPageUrl();
       // Assert.assertEquals(initialPageTitle, "LinkedIn: Log In or Sign Up";
        LinkedinBasePage homePage = loginPage.loginAs("ol2018@ukr.net", "0933386035");
        Assert.assertTrue(homePage.isSignedIn(), "User is not signed in");
        Assert.assertNotEquals(homePage.getPageTitle(), initialPageTitle,
                "Page title did not change after login");
        Assert.assertNotEquals(homePage.getPageUrl(), initialPageUrl,
                "Page url did not change after login");
    }

    @Test
    public void negativeLoginTest() {
        LinkedinLoginPage loginPage = new LinkedinLoginPage(driver);
        String initialPageTitle = loginPage.getPageTitle();
        String initialPageUrl = loginPage.getPageUrl();
        //LinkedinBasePage homePage = loginPage.loginAs("ol2018@ukr.net", "0933386035");
        LinkedinBasePage homePage = loginPage.loginAs("test@ukr.net", "12345");
        try {
            Assert.assertTrue(homePage.isSignedIn(), "User signed in");
            System.out.println("1");
        }catch (Exception e) {
            Assert.assertTrue(e.getMessage().contains("no such element"));
            System.out.println("2");
        }
        Assert.assertNotEquals(homePage.getPageTitle(), initialPageTitle,
                "Page title did not change after login");
        Assert.assertNotEquals(homePage.getPageUrl(), initialPageUrl,
                "Page url did not change after login");
    }
}