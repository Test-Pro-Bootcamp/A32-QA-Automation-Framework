import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class PlaylistTests extends BaseTest {

    @Test
    public void createPlaylist() {
        StepsPlaylist steps = new StepsPlaylist();
        HomePage homePage = new HomePage(getThreadLocal());

        steps.stepCreatedPlaylist();
        steps.stepDeletePlaylist();
        Assert.assertTrue(homePage.notificationText());
    }

    @Test
    public void addSongPlaylist() {
        HomePage homePage = new HomePage(getThreadLocal());
        StepsPlaylist steps = new StepsPlaylist();

        steps.stepCreatedPlaylist();
        steps.stepAddSongPlaylist();
        steps.stepDeletePlaylistWithOK();
        Assert.assertTrue(homePage.notificationText());
    }

    @Test
    public void deleteSongFromPlaylist() {
        HomePage homePage = new HomePage(getThreadLocal());
        StepsPlaylist steps = new StepsPlaylist();

        steps.stepCreatedPlaylist();
        steps.stepAddSongPlaylist();
        steps.stepDeleteSongFromPlaylist();
        steps.stepDeletePlaylist();
        Assert.assertTrue(homePage.notificationText());
    }

    @Test
    public void renamePlaylist() {
        HomePage homePage = new HomePage(getThreadLocal());
        StepsPlaylist steps = new StepsPlaylist();

        steps.stepCreatedPlaylist();
        steps.stepRenamePlaylist();
        steps.stepDeletePlaylist();
        Assert.assertTrue(homePage.notificationText());
    }

    @Test
    public void deletePlaylist() {
        HomePage homePage = new HomePage(getThreadLocal());
        StepsPlaylist steps = new StepsPlaylist();

        steps.stepCreatedPlaylist();
        steps.stepDeletePlaylist();
        Assert.assertTrue(homePage.notificationText());
    }
}