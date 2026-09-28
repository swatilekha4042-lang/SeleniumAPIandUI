package pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class qspidersLoginPage extends BasePage {

    @FindBy(xpath = "//section[text()='Dropdown']")
    private WebElement dropdownBtn;

    @FindBy(xpath = "//select//option[text()='Select country']")
    private WebElement countryDrpDwn;

    @FindBy(xpath = "//select//option[text()='Select State']")
    private WebElement stateDrpDwn;

    @FindBy(xpath = "//select//option[text()='Select City']")
    private WebElement cityDrpDwn;

    @FindBy(xpath = "//li//section[text()='Frames']")
    private WebElement framesButton;

    @FindBy(xpath = "//section[text()='iframes']//ancestor::a")
    private WebElement iframesOption;

    @FindBy(xpath = "//input[@id='username']")
    private WebElement usernameTxtBox;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordTxtBox;

    @FindBy(xpath = "//button[@id='submitButton']")
    private WebElement submitBtn;

    @FindBy(css = ".w-full.h-96")
    private WebElement iframe;

    @FindBy(xpath = "//li//section[text()='Popups']")
    private WebElement popupsTab;

    @FindBy(xpath = "//li//section[text()='Browser Windows']")
    private WebElement browserWindowTab;

    @FindBy(xpath="//a[text()='New Tab']")
    private WebElement newTabLink;

    @FindBy(xpath="//h2[text()='Watches']//following-sibling::button")
    private WebElement watchViewMoreBtn;

    @FindBy(xpath="//h2[text()='Laptop']//following-sibling::button")
    private WebElement laptopViewMoreBtn;

    By watchViewXpath =By.xpath("//h2[text()='Watches']//following-sibling::button");
    public qspidersLoginPage(WebDriver driver) {
        super(driver);
    }

    public void goToIFrames() {
        waitForVisibility(framesButton);
        waitForClickable(framesButton);
        framesButton.click();
        waitForClickable(iframesOption);
        iframesOption.click();
        waitForFrameToBeAvailableAndSwitch(iframe);
    }

    public void enterDetailsInTheFrame(String user, String password) {
        usernameTxtBox.sendKeys(user);
        passwordTxtBox.sendKeys(password);
        submitBtn.click();
    }

    public void switchBrowserWindows()
    {
        waitForClickable(popupsTab);
        popupsTab.click();

        waitForClickable(browserWindowTab);
        browserWindowTab.click();

        waitForClickable(newTabLink);
        newTabLink.click();
        
        String parentWindow=driver.getWindowHandle();
        waitForClickable(watchViewXpath);
        watchViewMoreBtn.click();

        driver.switchTo().window(parentWindow);

        waitForClickable(laptopViewMoreBtn);
        laptopViewMoreBtn.click();

        Set<String> windowHandles=driver.getWindowHandles();

        for(String handle:windowHandles)
        {
            driver.switchTo().window(handle);
            if(!handle.equals(parentWindow))
            {
                System.out.println(driver.getTitle());
                driver.close();
            }
                
            
        }
        
    }

}
