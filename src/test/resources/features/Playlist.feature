Feature: Create Playlist feature

  Background:
    Given I open Login Page
    Given I login success

  Scenario: Create Playlist
    And I click on plus-button
    And I select create new playlist
    And I enter a name of Playlist and click ENTER
    Then I get notification 'Created playlist'


  Scenario: Add Song To Playlist
    And I open AllSongs page
    And I select the first song from AllSongs
    And I click on AddTo button
    And I select the first playlist
    Then I get notification


  Scenario: Delete Song From Playlist
    And I click on playlist
    And I select the first song from Playlist
    And I delete a song by DELETE keyboard
    Then I get notificationEmptyList


  Scenario: rename Playlist
    And I double click on playlist
    And I enter a new name of playlist and click ENTER
    Then I get notificationRenamePlaylist 'Updated playlist'


  Scenario: delete Playlist
    And I click on playlist
    And I click on red delete-button
    And I see message notification
    Then I get notificationDeletedPlaylist 'Deleted playlist'

