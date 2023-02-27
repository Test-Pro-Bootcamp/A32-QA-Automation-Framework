Feature: Songs feature

  Scenario: Play a song
    Given I open browser
    And I login success
    And I open Songs Page
    When I click on first song
    Then Song is playing