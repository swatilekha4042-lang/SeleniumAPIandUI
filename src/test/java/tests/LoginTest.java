package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import pages.LoginPage;
import utils.ConfigReader;
import utils.DriverManager;

public class LoginTest extends BaseTest{

    private LoginPage loginPage;

    @BeforeMethod 
    public void setUpLoginPage(){
        loginPage= new LoginPage(DriverManager.getDriver());
        String baseUrl = ConfigReader.get("url");
        DriverManager.getDriver().get(baseUrl);
    }

    @DataProvider (name="loginData")
    public Object[][] getLoginData()
    {
        return new Object[][]
        {
          {"locked_out_user","secret_sauce"},
          {"problem_user","secret_sauce"}
        };
    }
    @Test 
    public void verifySiteLogin()
    {
       loginPage.login(ConfigReader.get("username"),ConfigReader.get("password"));
    }

    @Test(dataProvider = "loginData")
    public void verifyMultipleLogin(String user,String password)
    {
       loginPage.login(user,password);
    }

}