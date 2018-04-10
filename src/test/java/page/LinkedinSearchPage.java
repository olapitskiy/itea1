package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class LinkedinSearchPage extends LinkedinBasePage{

    @FindBy(xpath = "//li[contains(@class,'search-result__occluded-item')]")
    private List<WebElement> resultsWebElementList;

    @FindBy(xpath = "//h3[contains(@class,'search-results__total')]")
    private WebElement resultsNumber;

    /**
     *передача параметров WebDriver родительскому классу (LinkedinBasePage) super(driver);
     * и вызываем PageFactory.initElements(driver, this).
     * Драйвер не начинает искать элементы на странице сразу же, а ищет их как только мы обращаемся к полю класса
     * @param driver передаём WebDriver
     */
    public LinkedinSearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * просотр результатов поиска с поощью скрола
     * @return results String List
     */
    public List<String> getResults() {
        waitUntilElementIsVisible(resultsNumber, 10);
        List<String> resultsStringList = new ArrayList();
        for (WebElement result : resultsWebElementList) {
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", result);
            String cardTitle = result.getText();
            resultsStringList.add(cardTitle);
            //System.out.println("XXXX");
            //System.out.println(cardTitle);

        }

        return resultsStringList;
    }

    /**
     * проверяет загрузилась ли страница или нет
     * @return isLoaded ( true - если страница загрузилась, false -  если страница не загрузилась)
     */
    public boolean isLoaded() {
        boolean isLoaded;
        try {
            isLoaded = resultsNumber.isDisplayed();
        }
        catch (NoSuchElementException e){
            isLoaded = false;
        }
        return isLoaded;
    }
}