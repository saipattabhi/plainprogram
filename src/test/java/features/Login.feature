Feature: Application login


Scenario: Login with valid crendtials
Given open application
And I navigated to Login page
When I enter username as "saipattabhi18@gmail.com" and password as "sai@2255"
And user clicks on login button
Then User should able to see Successfull status 


