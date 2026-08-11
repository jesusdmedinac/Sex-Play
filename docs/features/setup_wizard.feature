Feature: Setup Wizard Navigation
  As a couple setting up the game
  I want a step-by-step wizard
  So that configuring the game is clear, engaging, and stress-free

  Scenario: Moving through setup steps
    Given the application is on Step 1 (Player Profiles)
    When players fill in their names and press "Next"
    Then the wizard advances to Step 2 (Mood & Intensity)
    And players can navigate back to Step 1 if needed
