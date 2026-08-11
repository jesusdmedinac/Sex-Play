Feature: Card Drawing System
  As an active player
  I want to see my action card and pass the turn
  So that the game maintains a steady pace

  Scenario: Standard Turn
    Given it is "Player 1"'s turn
    When the screen displays the current random action card
    And "Player 1" presses the "Next Turn" button
    Then the system randomly selects a new action card from the hardcoded list
    And the turn automatically passes to "Player 2"
