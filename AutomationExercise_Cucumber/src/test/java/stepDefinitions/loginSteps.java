package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import base.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class loginSteps 
{
	WebDriver driver;
	LoginPage login;
	HomePage home;

	@When("I enter correct email address {string} and password {string}")
	public void i_enter_correct_email_address_and_password(String string, String string2) 
	{
		BaseClass.getLogger().info("Entering email id and password");
		login=new LoginPage(BaseClass.getDriver());
		login.SendEmail(string);
		login.SendPassword(string2);
		
	}

	@And("I click on login button")
	public void i_click_on_login_button() 
	{
		BaseClass.getLogger().info("Clicking on Login button");
		login=new LoginPage(BaseClass.getDriver());
		login.ClickLogin();
	}
	
	@Then("verify if Logged in as username is visible")
	public void verify_if_Logged_in_as_username_is_visible() 
	{
		BaseClass.getLogger().info("User verifying the username");
		home=new HomePage(BaseClass.getDriver());
		String name=home.VerifyLoggedIn();
		Assert.assertEquals("Bala T", name);
	}
	
	@When("I click on the logout button")
	public void I_click_on_the_logout_button()
	{
		BaseClass.getLogger().info("Clicking on the logout button");
		home=new HomePage(BaseClass.getDriver());
		home.ClickLogout();
	}

}
