import org.testng.annotations.Test;

public class Homework18 extends BaseTest {

    @Test
    public static void playSong() {
        loginKoel();
        navigateToAllSongs();
        songDoubleClick();
        songIsPlaying();


    }
}
