Feature: Register
		@Regression
	Scenario:
		Given the user is on Home Page
		When the user clicks on SignuporLogin button 
		And the user enters name and email address, and clicks Signup button
		And the user fills the required details and clicks Create Account button
		And the user clicks Continue button
		Then the should verify that Logged in as username is visible		
		When the user deletes the account
		And Vefiry if the account deleted