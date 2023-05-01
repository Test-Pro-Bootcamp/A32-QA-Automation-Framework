Feature: Create Playlist feature

  Background:
  Given I open Login Page

  Scenario: Create Playlist
    When I login success
    And I click on plus-button
    And I select create new playlist
    And I enter a name of Playlist and click ENTER
    Then I get notification 'Created playlist'

Feature: AddSongToPlaylist feature

  Scenario: Add Song To Playlist
    When I login success
    And I open AllSongs page
    And I select the first song
    And I click on AddTo button
    And I select the first playlist
    Then I get notification


Feature: DeleteSongFromPlaylist feature

  Scenario: Delete Song From Playlist
    When I login success
    And I click on playlist
    And I select the first song
    And I delete a song by DELETE keyboard
    Then I get notificationEmptyList

Feature: RenamePlaylist feature

  Scenario: rename Playlist
    When I login success
    And I double click on playlist
    And I enter a new name of playlist and click ENTER
    Then I get notificationRenamePlaylist 'Updated playlist'

Feature: DeletePlaylist feature

  Scenario: delete Playlist
    When I login success
    And I click on playlist
    And I click on red delete-button
    Then I get notificationDeletedPlaylist 'Deleted playlist'

