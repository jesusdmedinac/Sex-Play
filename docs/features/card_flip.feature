Feature: Card Flip Animation
  As an active player
  I want an animation when drawing or revealing cards
  So that drawing a card feels tactile and exciting

  Scenario: Tapping Next Turn triggers a card flip
    Given the player is on the Gameplay screen
    When they press the "Next Turn" button or tap the card
    Then the card executes a 3D horizontal flip animation before showing the new action
