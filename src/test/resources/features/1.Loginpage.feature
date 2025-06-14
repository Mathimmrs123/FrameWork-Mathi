@Login

Feature: Verify LMX login page

  Scenario Outline: Verify LMX Login With Valid Credentials
    Given Check the loading time of the url
    Scenario Outline: Favicon icon
    When Check the lmx favicon icon is present or not
    Scenario Outline: LMX logo
    And check the lmx loco is present or not
    #Scenario Outline: Invalid Credential
    #And User provide invalid "UserName" and "password" and check the error message
    #Scenario Outline: Invalid Email
    #Then click Forgot username or password button and provide a invalid email and check error message
    #Scenario Outline: EmailSuccess Message
    #And check email success message is display after provide correct email 
    Scenario Outline: Valid Credential
    Then User provide valid "userneme" and "Password" 
    Scenario Outline: Login Success Message
    And Check the login success message and loading time when click the login button enthrough to home page
    