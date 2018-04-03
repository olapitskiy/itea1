package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static java.lang.Thread.sleep;

public class BadCodeExample {

	public static void main(String args[]) throws InterruptedException {
		System.out.println("Hello World");
		System.setProperty("webdriver.chrome.driver", "D:\\gooolech driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		sleep(5000);
	}
}

//      Assert.assertEquals(initialPageTitle, "LinkedIn: Войти или зарегистрироваться",
//             "Login page title is wrong");
//     LinkedinHomePage homePage = landingPage.loginAs("ol2018@ukr.net", "0933386035");
//            package test;