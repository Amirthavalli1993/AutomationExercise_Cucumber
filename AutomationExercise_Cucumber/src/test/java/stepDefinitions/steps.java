package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import base.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AccountCreatedPage;
import pageObjects.AccountDeletePage;
import pageObjects.EnterAccountInformationPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class steps 
{
	WebDriver driver;
	HomePage home;
	LoginPage login;
	EnterAccountInformationPage accinfo;
	AccountCreatedPage acccreate;
	AccountDeletePage accdelete;
	String uname;
	
	@Given("the user is on Home Page")
	public void the_user_is_on_home_page() 
	{
	  BaseClass.getLogger().info("The user is on Home Page");
	  home=new HomePage(BaseClass.getDriver());
	  String msghome=home.confirmMessage();
	  System.out.println(msghome);
	  Assert.assertEquals(msghome, "AutomationExercise");
	}

	@When("the user clicks on SignuporLogin button")
	public void the_user_clicks_on_SignuporLogin_button() 
	{
		BaseClass.getLogger().info("The user clicking signup button");
	    home=new HomePage(BaseClass.getDriver());
	    home.clickSignupOrLogin();
	}

	@And("the user enters name and email address, and clicks Signup button")
	public void the_user_enters_name_and_email_address_and_clicks_Signup_button() 
	{
		BaseClass.getLogger().info("User enters name and email address");
		login=new LoginPage(BaseClass.getDriver());
		uname=BaseClass.randomString();
		login.EnterName(uname);;
		login.EnterEmail(BaseClass.randomString()+"@gmail.com");
		login.ClickSignup();
	}

	@And("the user fills the required details and clicks Create Account button")
	public void the_user_fills_the_required_details_and_clicks_Create_Account_button() 
	{
		BaseClass.getLogger().info("User filling required details and clicking Create Account button");
		accinfo=new EnterAccountInformationPage(BaseClass.getDriver());
		accinfo.ClickTitle();
		accinfo.SendPassword(BaseClass.randomNumberAndString());
		accinfo.SelectDay("11");
		accinfo.SelectMonth("May");
		accinfo.SelectYear("2021");
		accinfo.SelectNewsLetterCheckBox();
		accinfo.SelectSpecialOffersCheckBox();
		accinfo.SendFirstName("qwert");
		accinfo.SendLastName("uiop");
		accinfo.SendAddress1("wgksdjhfsdlknsd");
		accinfo.SelectCountry("India");
		accinfo.SendState("TN");
		accinfo.SendCity("ED");
		accinfo.SendZipcode("789654");
		accinfo.SendMobileNumber(BaseClass.randomNumber());
		accinfo.ClickCreateAccount();
	}

	@And("the user clicks Continue button")
	public void the_user_clicks_Continue_button() 
	{
		BaseClass.getLogger().info("The user clicking continue button");
		acccreate=new AccountCreatedPage(BaseClass.getDriver());
		acccreate.ClickContinue();
	}

	@Then("the should verify that Logged in as username is visible")
	public void the_should_verify_that_Logged_in_as_username_is_visible() 
	{
		BaseClass.getLogger().info("User verifying the username");
		String name=home.VerifyLoggedIn();
		Assert.assertEquals(uname, name);
	}

	@When("the user deletes the account")
	public void the_user_deletes_the_account() 
	{
	   BaseClass.getLogger().info("The user deleting the account");
	   home.ClickDeleteAccount();
	}

	@And("Vefiry if the account deleted")
	public void vefiry_if_the_account_deleted() 
	{
	    BaseClass.getLogger().info("Vefirying if the accoutn deleted");
	    accdelete=new AccountDeletePage(BaseClass.getDriver());
	    String accdel=accdelete.VerifyAccountDeleted();
	    System.out.println(accdel);
	    Assert.assertEquals("ACCOUNT DELETED!", accdel);
	    accdelete.ClickContinue();
	    
	}





}
