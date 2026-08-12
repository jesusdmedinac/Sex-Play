Feature: Single-Action Setup Wizard
  As a couple setting up the game
  I want a clean, single-action wizard with no step counters
  So that configuring the game is effortless, focused, and intuitive

  Scenario: Navigating through single-question setup steps
    Given the players start the setup wizard
    When they complete each single-question screen and press "Siguiente"
    Then the wizard smoothly transitions to the next focused question without displaying step numbers
    And players can navigate back to previous questions at any point
