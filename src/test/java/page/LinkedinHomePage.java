package page;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinHomePage extends LinkedinBasePage{

    @FindBy(id = "profile-nav-item")
    private WebElement userIcon;

    @FindBy(xpath = "//input[@placeholder='Search']")
    private WebElement searchField;

    @FindBy(xpath = "//*[@type='search-icon']")
    private WebElement searchIcon;

    /**
     *
     * @param driver
     */
    public LinkedinHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     *
     * @return
     */
    public boolean isSignedIn() {
        waitUntilElementIsClickable(userIcon);
        return userIcon.isDisplayed();
    }

    /**
     *
     * @param searchTerm
     * @return
     */
    public LinkedinSearchPage searchByTerm(String searchTerm) {
        waitUntilElementIsClickable(searchField);
        searchField.sendKeys(searchTerm);
        searchIcon.click();
        return new LinkedinSearchPage(driver);
    }

    /**
     *
     * @return
     */
    public boolean isLoaded() {
        boolean isLoaded;
        try {
            isLoaded = userIcon.isDisplayed();
        }
        catch (NoSuchElementException e){
            isLoaded = false;
        }
        return isLoaded;
    }
}