Feature: ChangeProfileName feature


  Background I open Login Page

  Scenario: ChangeProfileName Success
    When I login success
    And I open Profile page
    And I enter random name
    And I enter password
    And I click Save
  Then I get notification

Feature: ChangeColorTheme feature

  Scenario: ChangeColorTheme Success
    When I login success
    And I open Profile page
    And I choose color theme
    Then The color theme is changed


Feature: ChooseCheckboxNotify feature

  Scenario: ChangeColorTheme Success
    When I login success
    And I open Profile page
    And I click on the first checkbox Notify
    Then I see the tick inside the box