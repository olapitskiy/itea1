package page;


import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinChooseNewPasswordPage extends LinkedinBasePage{

    @FindBy(xpath = "//input[@name='new_password']")
    private WebElement newPasswordField;

    @FindBy(xpath = "//input[@name='new_password_again']")
    private WebElement newPasswordRetypeField;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement submitButton;

    /**
     *передача параметров WebDriver родительскому классу (LinkedinBasePage) super(driver);
     * и вызываем PageFactory.initElements(driver, this).
     * Драйвер не начинает искать элементы на странице сразу же, а ищет их как только мы обращаемся к полю класса
     * @param driver передаём WebDriver
     */
    public LinkedinChooseNewPasswordPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * проверяе загрузилась ли страница или нет
     * @return isLoaded ( true - если страница загрузилась, false -  если страница не загрузилась)
     */
    public boolean isLoaded() {
        boolean isLoaded;
        try {
            isLoaded = newPasswordField.isDisplayed();
        }
        catch (NoSuchElementException e){
            isLoaded = false;
        }
        return isLoaded;
    }

    /**
     *вызов изменения пароля
     * @param newPassword ввод нового пароля
     * @return Password Changed Success Page
     */
    public LinkedinPasswordChangedSuccessPage submitNewPassword(String newPassword) {
        newPasswordField.sendKeys(newPassword);
        newPasswordRetypeField.sendKeys(newPassword);
        waitUntilElementIsClickable(submitButton).click();
        return new LinkedinPasswordChangedSuccessPage(driver);
    }

}