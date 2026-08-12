Feature: Emoji Removal & Universal Typography
  As a player on any web or mobile browser
  I want all UI text to be free of raw system font emojis
  So that all titles, buttons, and status indicators render cleanly without missing glyph boxes

  Scenario: Clean button and label text rendering
    Given any screen in the application
    When the text elements are displayed
    Then no emoji characters are present in button titles, badges, or dialog headers
