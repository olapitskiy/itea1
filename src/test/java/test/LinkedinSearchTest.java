
package test;

        import org.testng.Assert;
        import org.testng.annotations.Test;
        import page.LinkedinHomePage;
        import page.LinkedinSearchPage;

        import java.util.List;

public class LinkedinSearchTest extends LinkedinBaseTest{

    /**
     * Test that verifies basic Search by specific Search term
     */
    @Test
    public void basicSearchTest(){
        String searchTerm = "hr";

        LinkedinHomePage homePage = landingPage.loginAs("ol2018@ukr.net", "0933386035");
        LinkedinSearchPage searchPage = homePage.searchByTerm(searchTerm);
        List<String> results = searchPage.getResults();

        Assert.assertEquals(results.size(), 10, "Number of results is wrong");

        for (String result : results) {
            Assert.assertTrue(result.toLowerCase().contains(searchTerm),
                    "Searchterm "+searchTerm+ " not found in cart");
        }
    }
}








/*
public class LinkedinSearchTest {
    WebDriver driver;
    LinkedinSearchPage searchPage;
    LinkedinLandingPage landingPage;
    String initialPageTitle;
    String initialPageUrl;

    @BeforeMethod
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", "D:\\gooolech driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.linkedin.com/");
        searchPage = new LinkedinSearchPage(driver);
        landingPage = new LinkedinLandingPage(driver);
        initialPageTitle = landingPage.getPageTitle();
        initialPageUrl = landingPage.getPageUrl();
        String abc= landingPage.getPageTitle();
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
    }

    @Test
    public void basicSearchTest() throws InterruptedException {
        String searchTerm = "hr";
        Assert.assertEquals(initialPageTitle, "LinkedIn: Войти или зарегистрироваться");
        LinkedinHomePage homePage = landingPage.loginAs("ol2018@ukr.net", "0933386035");
        LinkedinSearchPage searchPage = homePage.searchByTerm(searchTerm);
        List<String> results = searchPage.geResults();
        sleep (5000);
        Assert.assertEquals(results.size(), 10, "Number of results is wrong");
        for (String result: results)   {
            Assert.assertTrue(result.toLowerCase().contains(searchTerm),
                    "Searchterm "+searchTerm+ "not found in cart number");
        }
    }
}
*/