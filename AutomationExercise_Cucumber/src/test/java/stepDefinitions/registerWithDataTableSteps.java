package stepDefinitions;

import java.util.Map;

import base.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pageObjects.EnterAccountInformationPage;

public class registerWithDataTableSteps 
{
	EnterAccountInformationPage accinfo;
	
	@When("the user enter the details into below fields")
	public void the_user_enter_the_details_into_below_fields(DataTable dataTable)  //dataTable comes from cucumber itself not from Java 
	{
		BaseClass.getLogger().info("Registering with DataTable concepts");
		Map<String, String> hashmap=dataTable.asMap(String.class, String.class); //converted from dataTable to hashMAp
		accinfo=new EnterAccountInformationPage(BaseClass.getDriver());
		accinfo.ClickTitle();
		accinfo.SendPassword(hashmap.get("password"));
		accinfo.SelectDay(hashmap.get("day"));
		accinfo.SelectMonth(hashmap.get("month"));
		accinfo.SelectYear(hashmap.get("year"));
		accinfo.SelectNewsLetterCheckBox();
		accinfo.SelectSpecialOffersCheckBox();
		accinfo.SendFirstName(hashmap.get("firstName"));
		accinfo.SendLastName(hashmap.get("lastName"));
		accinfo.SendAddress1(hashmap.get("address"));
		accinfo.SelectCountry(hashmap.get("country"));
		accinfo.SendState(hashmap.get("state"));
		accinfo.SendCity(hashmap.get("city"));
		accinfo.SendZipcode(hashmap.get("zipcode"));
		accinfo.SendMobileNumber(hashmap.get("mobileNumber"));

	}

	@And("the user clicks Create Account button")
	public void the_user_clicks_create_account_button() 
	{
	   BaseClass.getLogger().info("Clicking create account button");
	   accinfo=new EnterAccountInformationPage(BaseClass.getDriver());
	   accinfo.ClickCreateAccount();
	}
}
