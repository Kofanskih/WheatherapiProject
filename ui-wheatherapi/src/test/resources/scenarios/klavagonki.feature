Feature: bot for site klavagonki

  Background: I'm on the main page
    Given Open main page "https://klavogonki.ru/go?type=normal"


  Scenario: Bot starts the game and enters words by itself
    When Start the game
    And Wait for the game start
    And Enter highlighted word in cicle
    Then Track the game is over and characters per minute more than 2500