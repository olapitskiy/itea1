import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static java.lang.Thread.sleep;

/**
 * Created by QA on 13.02.2018.
 */
public class BadCodeExample {
	public static void main(String args[]) throws InterruptedException {
		System.out.println("Hello World");
		System.setProperty("webdriver.chrome.driver", "D:\\gooolech driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Selenium");
		element.submit();
		sleep(5000);
		driver.close();
	}
}
//      Assert.assertEquals(initialPageTitle, "LinkedIn: Войти или зарегистрироваться",
//             "Login page title is wrong");
//     LinkedinHomePage homePage = landingPage.loginAs("ol2018@ukr.net", "0933386035");
//            package test;