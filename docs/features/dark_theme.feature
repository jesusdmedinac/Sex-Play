Feature: Sensual Dark Theme
  As a player
  I want a dark, intimate, and visually striking theme
  So that the app sets the right mood and feels premium

  Scenario: App applies custom theme tokens
    Given the application is running
    When any screen (Setup, Gameplay, Resolution) is displayed
    Then the background uses deep burgundy tones
    And key action buttons use glowing crimson accents
