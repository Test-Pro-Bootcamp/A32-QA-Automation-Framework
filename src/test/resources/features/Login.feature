Feature: Login feature

  Scenario: Login Success
    Given I open Login Page
    When I enter valid email "burkovads@mail.ru"
    And I enter valid password "Julka@0721"
    And I submit
    Then I am logged in

  Scenario: Login with non-existing email
    Given I open Login Page
    When I enter non-existing email "burkova@mail.ru"
    And I enter valid password "Julka@0721"
    And I submit
    Then I am still on the login page

  Scenario: Login with incorrect password
    Given I open Login Page
    When I enter valid email "burkovads@mail.ru"
    And I enter non-existing password "Julka"
    And I submit
    Then I am still on the login page

  Scenario: Login with empty email
    Given I open Login Page
    When I enter empty email " "
    And I enter valid password "Julka@0721"
    And I submit
    Then I am still on the login page

  Scenario: Login with empty password
    Given I open Login Page
    When I enter valid email "burkovads@mail.ru"
    And I enter empty password " "
    And I submit
    Then I am still on the login page

Feature: Logout feature

  Scenario: Logout Success
    Given I login success
    When I click on logout button
    Then I am logged out
