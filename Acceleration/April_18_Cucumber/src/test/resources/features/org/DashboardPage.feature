Feature: Dashboard page feature

@Regression @Smoke
Scenario: Verify Dashboard page URL
Given User is on login page
When User enters username
And User enters password 
And User clicks on Login botton
And Dashboard page is displayed
And Dashboard URL is "http:localhost/user/submit_tt.do"

@Regression @Smoke
Scenario: Verify Dashboard page Title
Given User is on login page
When User enters username
And User enters password
And User clicks on Login button
Then Dashboard page is displayed
And Dashboard Title is "actiTime - Enter Time-Track"

@Regression @Smoke
Scenario: Verify Dashboard page tabs
Given User is on login page
When User enters username
And User enters password
And User clicks on Login button
Then Dashboard page is displayed	
And Dashboard displayed 4 tabs
And By default "TIME-Track" tab is selected