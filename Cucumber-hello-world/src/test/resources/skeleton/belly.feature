Feature: BellyFeature

  Scenario: 1
    Given I have eaten 20 cukes
    When I wait 5 hour
    Then my Belly should growl

  Scenario: 2
    Given I have eaten 5 cukes
    When I wait 2 hour
    Then my Belly should not growl


