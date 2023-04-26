Feature: Login feature

  Scenario: Login Success
    Given I open browser
    And I open Login Page
    When I enter email "burkovads@mail.ru"
    And I enter password "Julka@0721"
    And I submit
    Then I am logged in
