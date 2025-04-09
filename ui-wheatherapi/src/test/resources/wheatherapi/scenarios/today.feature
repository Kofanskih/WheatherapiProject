Feature: today weather

  Background: User is on the main page
    Given Open the main page "https://www.weatherapi.com/weather/"


  Scenario: User goes to the today page
    When User click to Today button
    Then User is on the Today page
    And Current weather is displayed

