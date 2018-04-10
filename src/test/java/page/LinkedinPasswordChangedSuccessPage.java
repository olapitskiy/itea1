package page;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinPasswordChangedSuccessPage extends LinkedinBasePage{

    @FindBy(xpath = "//div[@class='form-actions']/a[@href]")
    private WebElement goToHomeButton;

    /**
     *передача параметров WebDriver родительскому классу (LinkedinBasePage) super(driver);
     * и вызываем PageFactory.initElements(driver, this).
     * Драйвер не начинает искать элементы на странице сразу же, а ищет их как только мы обращаемся к полю класса
     * @param driver передаём WebDriver
     */

    public LinkedinPasswordChangedSuccessPage(WebDriver driver){
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
            isLoaded = goToHomeButton.isDisplayed();
        }
        catch (NoSuchElementException e){
            isLoaded = false;
        }
        return isLoaded;
    }

}