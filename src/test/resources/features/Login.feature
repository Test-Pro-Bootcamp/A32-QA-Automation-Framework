Feature: Login feature
  Scenario: Login success
    Given I open login page
    When I enter email "kamilakk@bk.ru"
    And I enter password "te$t$tudent"
    And I submit
    Then Im logged in

