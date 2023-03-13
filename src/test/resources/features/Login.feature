Feature: Login page tests

  Scenario: Login Success
    Given I open browser
    And I open Login Page
    When I enter email "vladakc@yahoo.com"
    And I enter password "te$t$tudent"
    And I submit
    Then I am logged in