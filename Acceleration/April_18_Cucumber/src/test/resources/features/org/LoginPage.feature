Feature: Login page feature

@Smoke
Scenario: Validate login page
Given User is on login page
Then User name field is displayed
And Password field is displayed
And Keep me login check box is displayed
And login button is displayed
And login logos is displayed

@Regression @Smoke
Scenario: Verify Login funtionality
Given User is on login page
When User enters username
And User enters username password
And User clicks on Login button
Then Dashboard page is displayed
And Dashboard URL is "http:localhost/user/submit_tt.do"
And Dashboard Title is "actiTime - Enter Time-Track"
And Dashboard displayed 4 