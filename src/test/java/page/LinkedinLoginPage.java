package page;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinLoginPage extends LinkedinBasePage{

    @FindBy(id = "session_key-login")
    private WebElement emailField;

    @FindBy(id = "session_password-login")
    private WebElement passwordField;

    @FindBy(id = "btn-primary")
    private WebElement signInButton;

    /**
     * передача параетров WebDriver родительскому классу (LinkedinBasePage) super(driver);
     * и вызываем PageFactory.initElements(driver, this).
     * Драйвер не начинает искать элементы на странице сразу же,
     * а ищет их как только мы обращаемся к полю класса
     *
     * @param driver передаём WebDriver
     */
    public LinkedinLoginPage(WebDriver driver){
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
            isLoaded = emailField.isDisplayed();
        }
        catch (NoSuchElementException e){
            isLoaded = false;
        }
        return isLoaded;
    }
}