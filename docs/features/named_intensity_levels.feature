Feature: Named Intensity Levels
  As a player configuring the game
  I want punishment intensity levels to be displayed with descriptive names instead of numbers
  So that I clearly understand the nature and tone of the consequences

  Scenario: Displaying named intensity levels in setup
    Given the players are on Step 2 of the setup wizard
    When they view the maximum punishment level options
    Then the options display "Juguetón & Sensorial", "Dominación & Control", "Control & Castidad", and "Línea del Tabú"
