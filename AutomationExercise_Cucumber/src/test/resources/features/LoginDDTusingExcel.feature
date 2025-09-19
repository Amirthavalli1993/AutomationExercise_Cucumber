Feature:
	Scenario Outline:
		Given the user is on Home Page
		When the user clicks on SignuporLogin button
		And the user should be redirected to LoginPage by providing email and password with Excel row "<row_index>"
	
		Examples:
			| row_index |
			| 		  1 |
			| 		  2 |
			| 		  3 |
			| 		  4 |
			| 		  5 |
