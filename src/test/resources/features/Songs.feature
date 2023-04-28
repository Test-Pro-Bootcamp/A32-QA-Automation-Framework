Feature: SongsActions feature

  Background:
    Given I open Login Page

  Scenario: Play song with Shuffle button
    When I login success
    And I open AllSongs page
    And I click on All shuffle button
    Then Song is playing

  Scenario: Play song by double click
    When I login success
    And I open AllSongs page
    And I double click on first song
    Then Song is playing

  Scenario: Play song from dropdown list
    When I login success
    And I open AllSongs page
    And I right click on first song
    And I select Play
    Then Song is playing

  Scenario: Search song
    When I login success
    And I click on search field
    And I enter name of song and click ENTER
    Then Song is playing

