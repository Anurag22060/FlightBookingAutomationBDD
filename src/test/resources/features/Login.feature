Feature: User Login Functionality

  Scenario: Login with valid credentials
    Given the user is on the login page
    When the user enters a valid username and password
    Then the user should be redirected to the dashboard

  Scenario: Login with invalid username
    Given the user is on the login page
    When the user enters an invalid username and a valid password
    Then an "Invalid credentials" error should be displayed

  Scenario: Login with invalid password
    Given the user is on the login page
    When the user enters a valid username and an invalid password
    Then an "Invalid credentials" error should be displayed

  Scenario: Login with empty fields
    Given the user is on the login page
    When the user leaves the username and password fields empty
    Then an error message "Username and password are required" should be displayed

  Scenario: Invalid CAPTCHA validation
    Given the user is on the login page
    When the user enters valid credentials but invalid CAPTCHA
    Then an error message "Invalid CAPTCHA" should be displayed

  Scenario: Empty CAPTCHA validation
    Given the user is on the login page
    When the user enters valid credentials but leaves CAPTCHA empty
    Then an error message "CAPTCHA is required" should be displayed

  Scenario: CAPTCHA case sensitivity check
    Given the user is on the login page
    When the user enters CAPTCHA in different case
    Then an error message "CAPTCHA is case sensitive" should be displayed
