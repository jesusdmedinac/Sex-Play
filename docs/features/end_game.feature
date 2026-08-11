Feature: End Game Resolution
  As a player pushed to the limit
  I want to surrender and trigger the endgame
  So that a winner is declared and consequences are applied

  Scenario: A player surrenders and the winner chooses the outcome
    Given the game is currently in progress
    When "Player 2" presses the "I Surrender!" button
    Then the game ends immediately
    And "Player 1" is declared the Winner
    And the system prompts "Player 1" to choose either a "Reward" or a "Punishment"
    
  Scenario: Winner selects the consequence
    Given the game has ended and the winner's choice prompt is visible
    When "Player 1" selects "Punishment"
    Then the system randomly selects a Punishment title from the configured intensity level
    And the screen displays the chosen Punishment Title to be executed
