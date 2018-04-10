package page;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinRequestPasswordResetPage extends LinkedinBasePage{

    @FindBy(xpath = "//input[@name='userName']")
    private WebElement userNameField;

    @FindBy(xpath = "//input[@name='request']")
    private WebElement submitButton;

    /**
     *передача параметров WebDriver родительскому классу (LinkedinBasePage) super(driver);
     * и вызываем PageFactory.initElements(driver, this).
     * Драйвер не начинает искать элементы на странице сразу же, а ищет их как только мы обращаемся к полю класса
     * @param driver передаём WebDriver
     */
    public LinkedinRequestPasswordResetPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * submit Email
     * @param userEmail
     * @return new Password Reset Submit Page
     */
    public LinkedinPasswordResetSubmitPage submitEmail(String userEmail) {
        userNameField.sendKeys(userEmail);
        waitUntilElementIsClickable(submitButton);
        submitButton.click();
        return new LinkedinPasswordResetSubmitPage(driver);
    }

    /**
     * проверяе загрузилась ли страница или нет
     * @return isLoaded ( true - если страница загрузилась, false -  если страница не загрузилась)
     */
    public boolean isLoaded() {
        boolean isLoaded;
        try {
            isLoaded = userNameField.isDisplayed();
        }
        catch (NoSuchElementException e){
            isLoaded = false;
        }
        return isLoaded;
    }
}