Feature: Session Statistics Display
  As a player finishing a game
  I want to see statistics about our session (time played and cards drawn)
  So that we can appreciate our resistance and shared experience

  Scenario: Viewing end-game statistics
    Given a game session has ended
    When the Resolution screen is displayed
    Then it shows total cards played and total session time in minutes and seconds
