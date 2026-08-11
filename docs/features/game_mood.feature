Feature: Game Mood Filtering
  As a player
  I want to select the overall mood of the game
  So that the action deck only includes cards matching our desired vibe

  Scenario: Selecting a Romantic mood filters the deck
    Given the players are on Step 2 of the setup wizard
    When they select the "Romantic & Sensory" mood
    Then the game engine filters the active deck to only include cards tagged with the Romantic mood
