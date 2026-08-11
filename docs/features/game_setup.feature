Feature: Game Setup
  As a player
  I want to quickly set up the game
  So that we can start playing without complex configurations

  Scenario: Starting a new game
    Given the application is on the Home screen
    When the users enter their names "Player 1" and "Player 2"
    And they select the maximum allowed intensity level (1 to 4)
    And they press the "Start Game" button
    Then the application navigates to the Game screen
    And the first turn begins for "Player 1"
