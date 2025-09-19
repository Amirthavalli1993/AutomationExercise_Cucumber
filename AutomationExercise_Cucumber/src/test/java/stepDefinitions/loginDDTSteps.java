package stepDefinitions;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;

import base.BaseClass;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import utilities.DataReader;

public class loginDDTSteps 
{
	WebDriver driver;
	LoginPage login;
	HomePage home;
	List<HashMap<String, String>> datamap;
	
	@When("the user should be redirected to LoginPage by providing email and password with Excel row {string}")
	public void the_user_should_be_redirected_to_login_page_by_providing_email_and_password_with_excel_row(String rows) throws IOException 
	{
	   BaseClass.getLogger().info("Login DDt using Excel file");
	   try {
	   datamap = DataReader.data(System.getProperty("user.dir")+".\\testData\\Data.xlsx", "Sheet1");
	   
	   int index = Integer.parseInt(rows)-1;
	   
	   String email=datamap.get(index).get("Email");
	   String password=datamap.get(index).get("Password");
	   String result=datamap.get(index).get("Result");
	   
	   login=new LoginPage(BaseClass.getDriver());
	   login.SendEmail(email);
	   login.SendPassword(password);
	   login.ClickLogin();
	   
	   home=new HomePage(BaseClass.getDriver());	   
	   String uname=home.VerifyLoggedIn();
	   
	   if(result.equalsIgnoreCase("Valid"))
	   {
		   if(uname.equals("Bala T"))
		   {
			   home.ClickLogout();
			   Assert.assertTrue(true);
		   }
	   }
	   else
	   {
		   Assert.assertTrue(false);
	   }
	   
	   if(result.equalsIgnoreCase("Invalid"))
	   {
		   if(uname.equals("Bala T"))
		   {
			   home.ClickLogout();
			   Assert.assertTrue(false);
		   }
		   
	   }
	   else
	   {
		   Assert.assertTrue(true);
	   }
	  	
	   }catch(Exception e)
	   {
		   e.printStackTrace();
	   }
	   
	}
}
