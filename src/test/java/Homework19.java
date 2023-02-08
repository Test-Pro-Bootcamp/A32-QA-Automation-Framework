import org.testng.annotations.Test;

public class Homework19 extends BaseTest {
    @Test
    public static void deletePlaylist() {
        loginKoel();
        openPlaylistPage();
        clickDeleteBtn();
        verifyPlaylistDeleted();


    }

}
