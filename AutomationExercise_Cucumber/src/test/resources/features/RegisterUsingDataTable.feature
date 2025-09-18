Feature: Register
		@Regression
	Scenario:
		Given the user is on Home Page
		When the user clicks on SignuporLogin button 
		And the user enters name and email address, and clicks Signup button
		When the user enter the details into below fields
			| firstName | Sanath 					|
			| lastName 	| Bala 						|
			| password 	| San@123 					|
			| day	 	| 16 						|
			| month 	| October 					|
			| year  	| 1989  					|
			| address 	| 17, mariamman street kindu |
			| country 	| India 					|
			| state 	| TamilNadu 				|
			| city 		| Erode 					|
			| zipcode 	| 666666 					|
			| mobileNumber | 3333333333 			|
		And the user clicks Create Account button
		And the user clicks Continue button
		Then the should verify that Logged in as username is visible		
		When the user deletes the account
		And Vefiry if the account deleted
			