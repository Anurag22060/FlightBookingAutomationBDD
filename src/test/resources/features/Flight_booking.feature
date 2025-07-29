Feature: Flight Booking Field Validations

  Scenario: Validate dropdown for 'Travel From' and 'Travel To'
    Given the user is on the booking page
    When the user clicks on the "Travel From" and "Travel To" dropdowns
    Then the dropdown options should be displayed and selectable

  Scenario: Validate 'Departure Date' field
    Given the user is on the booking page
    When the user enters a valid date in the "Departure Date" field
    Then the date should be accepted

  Scenario: Validate 'Passenger Name' field
    Given the user is on the booking page
    When the user enters a valid passenger name
    Then the input should be accepted

  Scenario: Validate 'Email' field
    Given the user is on the booking page
    When the user enters a valid email
    Then the email should be accepted
