package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ConfigReader;

public class LoginPage extends BasePage{
    

   @FindBy(id="user-name")
   private WebElement usernameTxtBox;

   @FindBy (id="password")
   private WebElement passwordtxtBox;

   @FindBy (css="[data-test='login-button']")
   private WebElement loginBtn;

   @FindBy(xpath="input[contains(@class,'submit-button')]")
   private WebElement loginBtnAlt;

   @FindBy(xpath="//input[@id='password']/..//following-sibling::input[@value='Login']")
   private WebElement loginBtnXpath;

   //Constructor
   public LoginPage(WebDriver driver)
   {
    super(driver);
   }
   
   public void enterUsername(String name)
   {
     waitForVisibility(usernameTxtBox).sendKeys(name);
   }

   public void enterPassword(String pass)
   {
    waitForVisibility(passwordtxtBox).sendKeys(pass);
   }
   
   public void clickLoginBtn()
   {
    waitForClickable(loginBtn);
    loginBtn.click();
   }

   public void login(String name, String password)
   {
      enterUsername(name);
      enterPassword(password);
      clickLoginBtn();

   }
   
}
