Feature: WCAG 2.1 Contrast Compliance
  As a user with visual sensitivities or high ambient light
  I want all text and interactive UI elements to satisfy WCAG 2.1 AA/AAA contrast ratios
  So that reading cards, button labels, and safe word badges is effortless and accessible

  Scenario: Primary button text satisfies AA contrast requirements
    Given a primary button rendered on screen
    When measuring the relative luminance of the button background and label
    Then the contrast ratio is greater than or equal to 4.5:1

  Scenario: Safe word badge satisfies AAA contrast requirements
    Given the safe word indicator badge rendered on screen
    When measuring the contrast ratio between badge background and red text
    Then the contrast ratio is greater than or equal to 7.0:1
