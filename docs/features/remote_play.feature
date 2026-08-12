Feature: Long Distance Remote Play Mode
  As a couple playing long distance via video call or chat
  I want to enable Remote Play Mode
  So that the app automatically excludes all in-person physical contact challenges and consequences

  Scenario: Enabling Remote Play Mode filters out physical contact cards
    Given the players are on Step 3 of the setup wizard
    When they check "Modo a Distancia / Remoto (Sin contacto en persona)"
    And they finish setup
    Then the active deck excludes all cards tagged with physical contact
    And only remote-friendly actions (verbal, visual, questions, teasing) are drawn
