import org.testng.annotations.Test;

public class Hw21 extends BaseTest {
    @Test
    public void createPlaylistTest() {
        logIn("demotesting@gmail.com", "te$t$tudent");
        createPlaylist();
        playlistSelect();
        enterNameofplaylist();
    }
    @Test
    public void renamePlaylistTest() {
        logIn("demotesting@gmail.com", "te$t$tudent");
        usersPlaylist();
        renamePlaylist("PlaylistTest");
    }
}
