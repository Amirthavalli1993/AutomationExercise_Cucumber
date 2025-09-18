Feature:
    	@Sanity
  Scenario Outline: Verify user can log in 
    Given the user is on Home Page
	When the user clicks on SignuporLogin button
    When I enter correct email address "<email>" and password "<password>"
    And I click on login button
    Then verify if Logged in as username is visible
    When I click on the logout button
    
   Examples:
	| email 			| password 	|
    | balasmb@gmail.com	| test@123	|
    | amy@gmail.com		| test123	|