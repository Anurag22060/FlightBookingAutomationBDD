Feature: Flight Search

  Scenario: Search flight by valid number
    Given I launch the flight booking application
    And I login with username "flightadmin" and password "flightadmin"
    When I search for flight number "AI101"
    Then I should see result containing "AI101"
