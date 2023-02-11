import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest {
    @Test
    public static void renamePlaylist() {
        loginKoel();
        String playlistName = "My new playlist";
        String newName = getPlaylistName();
        playlistDoubleClick();
        renamePlaylistName(playlistName);
        Assert.assertEquals(playlistName, newName);

    }
}
