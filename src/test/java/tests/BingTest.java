   package tests;
   import utils.ConfigReader;
   import utils.DriverManager;

   import org.testng.annotations.BeforeMethod;
   import org.testng.annotations.Test;

   import pages.BingPage;
   public class BingTest extends BaseTest{

      BingPage bingpage ;

      @BeforeMethod 
      public void setUpBing()
      {
         bingpage=new BingPage(DriverManager.getDriver());
         String baseurl=ConfigReader.get("bingUrl");
         DriverManager.getDriver().get(baseurl);
      }

      @Test 
      public void searchDropdown()
      {
         bingpage.selectTextInDropdown("testing");
         try{
         Thread.sleep(7000);
         }
         catch(Exception e)
         {
            
         }
         
         
      }
   }