Feature: Songs feature

  Background:
    Given I open Login Page

  Scenario: Play a song
    When I login success
    And I open Songs Page
    And I click on first song
    Then Song is playing