Feature: ChangeProfileName feature

  Background:
    Given I open Login Page
    Given I login success

  Scenario: Change Profile Name
    And I open Profile page
    And I enter random name
    And I enter password
    And I click Save
    Then I get notificationProfileUpdated 'Profile updated'

  Scenario: Change Color Theme
    And I open Profile page
    And I choose color theme
    Then The color theme is changed


  Scenario: Choose Checkbox Notify
    And I open Profile page
    And I click on the first checkbox Notify
    Then I see the tick inside the box