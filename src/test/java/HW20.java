import com.fasterxml.jackson.databind.ser.Serializers;
import org.testng.annotations.Test;

public class HW20 extends BaseTest {
    @Test
    public void createPlaylist2() {
        logIn("demotesting@gmail.com", "te$t$tudent");
        createPlaylist();
        Playlistselect();
        enterName();
    }
    @Test
    public void deletePlaylist2() {
        logIn("demotesting@gmail.com", "te$t$tudent");
        openPlaylist();
        deletePlaylist();
        successMessage();
    }
}
