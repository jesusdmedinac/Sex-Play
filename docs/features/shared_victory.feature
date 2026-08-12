Feature: Shared Victory on Card Limit Reached
  As a couple playing a timed mode
  I want a shared completion message if neither surrenders
  So that we are celebrated for reaching the end together

  Scenario: Completing 10 cards in Express Mode
    Given a game running in Express Mode on card 10
    When the active player completes the 10th card
    Then the game finishes with a "Shared Victory" status
    And both players are prompted to choose a joint reward
