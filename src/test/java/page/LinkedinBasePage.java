package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class LinkedinBasePage {
    WebDriver driver;

    /**
     * Constructor of LinkedinBasePage class which takes WebDriver instance initialized in @BeforeMethod
     * for reuse in LinkedinBasePage class methods
     * @param driver WebDriver instance
     */

    public LinkedinBasePage (WebDriver driver){
        this.driver = driver;
    }

    /**
     * получаем название страницы
     * @return возвращает строку с названием страницы
     */
    public String getPageTitle() {
        return driver.getTitle();
    }

    /**
     * получаем url адрес страницы
     * @return возвращает url адрес
     */
    public String getPageUrl() {
        return driver.getCurrentUrl();
    }

    /**
     * Wait 10 seconds until WebElement is Clickable on Web page
     * @param webElement - WebElement to Wait for
     * @return WebElement after wait
     */

    public WebElement waitUntilElementIsClickable (WebElement webElement){
        waitUntilElementIsClickable(webElement, 10);
        return webElement;
    }

    /**
     * Wait until WebElement is Clickable on Web page
     * @param webElement WebElement to Wait for
     * @param timeOutInSeconds целочисленное значение в секундах
     * @return WebElement after wait
     */
     public WebElement waitUntilElementIsClickable (WebElement webElement, int timeOutInSeconds){
         WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
         wait.until(ExpectedConditions.elementToBeClickable(webElement));
         return webElement;
     }
    /**
     * Wait until WebElement is Visible on Web page
     * @param webElement WebElement to Wait for
     * @param timeOutInSeconds целочисленное значение в секундах
     */
    public void waitUntilElementIsVisible (WebElement webElement, int timeOutInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    /**
     * абстрактный класс для создания методов isLoaded на всех наследниках класса
     * @return true or false
     */
    public abstract boolean isLoaded();

}