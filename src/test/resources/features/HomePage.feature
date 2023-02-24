Feature: HomePage feature
  Scenario: Play a song
    Given I open browser
    And I open Login page
    When I enter email "rumkostia92@gmail.com"
    And I enter password "te$t$tudent"
    And I submit
    Then I logged in
    When I click at song
    Then Song is playing
