package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BingPage extends BasePage {

    @FindBy(xpath = "//textarea[@type='search']")
    private WebElement inputText;

    @FindBy(xpath = "//ul[@role='listbox'][@aria-label='Suggestions']//li")
    private List<WebElement> drpDwnElements;

    public BingPage(WebDriver driver) {
        super(driver);
    }

    public void selectTextInDropdown(String input) {
        inputText.sendKeys(input);
        waitForVisibilityOfAllElements(drpDwnElements);
        for (WebElement option : drpDwnElements) {
            if (option.getText().contains(input)) {
                option.click();
                break;
            }

        }

    }
}
