Feature: CreatePlaylist feature

  Background I open Login Page

  Scenario: CreatePlaylist Success
    When I login success
    And I click on plus-button
    And I select create new playlist
    And I enter a name of Playlist and click ENTER
    Then I get notification 'Created playlist'

Feature: AddSongToPlaylist feature

  Scenario: AddSongToPlaylist Success
    When I login success
    And I open AllSongs page
    And I select the first song
    And I click on AddTo button
    And I select the first playlist
    Then I get notification


Feature: DeleteSongFromPlaylist feature

  Scenario: DeleteSongFromPlaylist Success
    When I login success
    And I click on playlist
    And I select the first song
    And I delete a song by DELETE keybord
    Then I get notification 'Removed song'

Feature: RenamePlaylist feature

  Scenario: renamePlaylist Success
    When I login success
    And I double click on playlist
    And I enter a new name of playlist and click ENTER
    Then I get notification 'Updated playlist'

Feature: DeletePlaylist feature

  Scenario: deletePlaylist Success
    When I login success
    And I click on playlist
    And I click on red delete-button
    Then I get notification

