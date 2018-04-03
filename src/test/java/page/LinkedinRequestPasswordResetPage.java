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
     *
     * @param driver
     */
    public LinkedinRequestPasswordResetPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     *
     * @param userEmail
     * @return
     */
    public LinkedinPasswordResetSubmitPage submitEmail(String userEmail) {
        userNameField.sendKeys(userEmail);
        waitUntilElementIsClickable(submitButton);
        submitButton.click();
        return new LinkedinPasswordResetSubmitPage(driver);
    }

    /**
     *
     * @return
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