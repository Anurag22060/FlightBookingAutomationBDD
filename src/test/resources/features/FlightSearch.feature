Feature: Flight Search Functionality

  Scenario: Search by valid flight number
    Given the user is on the flight search page
    When the user enters a valid flight number
    Then the corresponding flight details should be displayed

  Scenario: Search by valid flight name
    Given the user is on the flight search page
    When the user enters a valid flight name
    Then the corresponding flight details should be displayed

  Scenario: Search by flight type
    Given the user is on the flight search page
    When the user selects a flight type from the dropdown
    Then the filtered flight results should be displayed

  Scenario: Search with no result found
    Given the user is on the flight search page
    When the user enters an invalid flight number or name
    Then a message "No flights found" should be displayed

  Scenario: Blank search validation
    Given the user is on the flight search page
    When the user clicks search without entering any values
    Then an error message "Please enter search criteria" should be displayed
