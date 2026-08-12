Feature: Game Mode Selection
  As a player
  I want to choose between Express, Standard, or Marathon modes during setup
  So that we can tailor the game duration to our available time

  Scenario: Selecting Express Mode sets a 10-card limit
    Given the players are on Step 2 of the setup wizard
    When they select "Express Mode (10 Cards)"
    And they finish setup
    Then the active deck is limited to 10 cards
