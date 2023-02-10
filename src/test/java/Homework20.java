import org.testng.annotations.Test;

public class Homework20 extends BaseTest {
    @Test
    public static void playSong() {
        loginKoel();
        navigateToAllSongs();
        songDoubleClick();
        songIsPlaying();
    }
    @Test
    public static void CreatePlaylist() {
        loginKoel();
        createNewPlaylist();
        selectNewPlaylist();
        enterPlaylistName();
        verifyPlaylistCreated();
    }
    @Test
    public static void addSongToPlaylist() {
        loginKoel();
        navigateToAllSongs();
        selectSong();
        addToClick();
        selectPlaylist();
        open_m_Playlist();
        verifySongIsAdded();
    }
    @Test
    public static void deletePlaylist() {
        loginKoel();
        openPlaylistPage();
        clickDeleteBtn();
        verifySuccessDeleted();
    }

}
