Feature: Safe Word and Consent Boundaries
  As a safety-conscious player
  I want to define a custom safe word and select hard limits
  So that we feel completely secure and comfortable during play

  Scenario: Setting a custom safe word and excluding temperature play
    Given the players are on Step 3 of the setup wizard
    When they enter "Red" as their custom safe word
    And they check "Exclude Temperature Play"
    And they finish setup
    Then the safe word "Red" is persistently visible during gameplay
    And all action cards involving ice/heat are excluded from the deck
