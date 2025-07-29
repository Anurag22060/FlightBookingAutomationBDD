Feature: Booking Form Entry Validation

  Scenario: Submit form with all valid fields
    Given the user is on the booking form page
    When the user enters valid data in all fields
    And submits the form
    Then the form should be submitted successfully

  Scenario: Submit form without phone number
    Given the user is on the booking form page
    When the user fills all fields except phone number
    And submits the form
    Then the form should be submitted successfully

  Scenario: Submit form with 100-character name
    Given the user is on the booking form page
    When the user enters a name with exactly 100 characters
    Then the name field should accept the input

  Scenario: Submit form with multiline message
    Given the user is on the booking form page
    When the user enters a multiline message
    Then the form should be submitted successfully

  Scenario: Submit form using Tab and Enter keys
    Given the user is on the booking form page
    When the user navigates through the form using Tab
    And presses Enter to submit
    Then the form should be submitted successfully

  Scenario: Submit empty form
    Given the user is on the booking form page
    When the user leaves all fields empty and submits the form
    Then the system should display "All fields are required"

  Scenario: Submit with invalid email format
    Given the user is on the booking form page
    When the user enters an invalid email format
    Then an error message "Please enter a valid email" should be displayed

  Scenario: Submit phone number with letters
    Given the user is on the booking form page
    When the user enters alphabets in the phone number field
    Then an error message "Phone number must be numeric" should be displayed

  Scenario: Submit with blank message
    Given the user is on the booking form page
    When the user leaves the message field blank
    Then an error message "Message is required" should be displayed

  Scenario: Name field with 1 character
    Given the user is on the booking form page
    When the user enters only one character in name field
    Then an error message "Name must be at least 2 characters long" should be displayed

  Scenario: Name field exceeds max length
    Given the user is on the booking form page
    When the user enters a name longer than 100 characters
    Then an error message "Name cannot exceed 100 characters" should be displayed
