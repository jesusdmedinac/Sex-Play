Feature: Tension and Progress Tracker
  As a player
  I want to see how many turns/cards we have played in this session
  So that we can feel the rising tension of the game

  Scenario: Card count increases with each turn
    Given a game session is started with card count 1
    When "Player 1" completes their turn and passes to "Player 2"
    Then the session progress indicator increments to 2
