package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AccountCreatedPage extends BasePage 
{
	public AccountCreatedPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(how=How.XPATH, using="//b[normalize-space()='Account Created!']")
	WebElement msgAccountCreated;
	
	@FindBy(how=How.XPATH, using="//a[normalize-space()='Continue']")
	WebElement btnContinue;
	
	public String VerifyAccountCreation()
	{
		return msgAccountCreated.getText();
	}
	
	public void ClickContinue()
	{
		btnContinue.click();
	}

}
