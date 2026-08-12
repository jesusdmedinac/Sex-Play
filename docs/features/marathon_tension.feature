Feature: Marathon Mode Tension Indicator
  As a couple playing in Marathon Mode
  I want the linear progress bar to be hidden
  And I want a dynamic escalating tension badge that reflects our rising intensity
  So that the game feels endless yet psychologically intensifying

  Scenario: Progress bar is hidden in Marathon Mode
    Given a game running in Marathon Mode
    When the Gameplay screen is displayed
    Then the linear progress bar is excluded
    And the escalating tension status badge is displayed
