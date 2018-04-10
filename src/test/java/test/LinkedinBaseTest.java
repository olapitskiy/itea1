package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;
import page.LinkedinLandingPage;


public class LinkedinBaseTest {
    WebDriver driver;
    LinkedinLandingPage landingPage;

    /**
     *
     * @param browserType
     * @param envURL
     */

    @Parameters({"browserType", "envURL"})
    @BeforeMethod
    public void beforeTest(@Optional("chrome") String browserType, @Optional("https://ua.linkedin.com/") String envURL) {

        switch (browserType.toLowerCase()){
            case "chrome" :
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox" :
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default :
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
        }

        driver.navigate().to(envURL);
        landingPage = new LinkedinLandingPage(driver);
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
    }
}
//