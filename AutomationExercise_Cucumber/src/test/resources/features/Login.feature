Feature: User Login

	@Sanity
  Scenario: Verify user can log in 
    Given the user is on Home Page
	When the user clicks on SignuporLogin button
    When I enter correct email address "balasmb@gmail.com" and password "test@123"
    And I click on login button
    Then verify if Logged in as username is visible
    When I click on the logout button
    
    
