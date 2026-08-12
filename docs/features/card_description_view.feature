Feature: Card Click Description View
  As a player
  I want to tap an action or consequence card to see its full detailed description
  So that my partner and I understand exactly how to perform the challenge or consequence

  Scenario: Tapping an action card opens the detail dialog
    Given an action card is displayed during gameplay
    When the player taps on the card or the detail icon
    Then a detail modal opens displaying the full description and guidance for that action

  Scenario: Tapping a consequence card shows consequence instructions
    Given the end-game resolution screen displays a consequence title
    When the winner or loser taps on the consequence card
    Then a detail dialog opens displaying the complete reward or punishment instructions
