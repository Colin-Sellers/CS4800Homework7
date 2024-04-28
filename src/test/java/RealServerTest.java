import Part2Proxy.RealServer;
import Part2Proxy.Song;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RealServerTest
{
    Song testSong = new Song("Test", "Tester", "Testing", 10);
    RealServer testServer = new RealServer();
    // All Tests will have 'artificial' network latency
    @Test
    public void searchByIDTest()
    {
        Song returner = testServer.searchById(0);
        String expected = "Everlong"; // Auto Initialized
        String actual = returner.getTitle();
        assertEquals(expected, actual);
    }
    @Test
    public void searchByTitleTest()
    {
        testServer.addSong(testSong);
        List<Song> returned= testServer.searchByTitle("Test");
        Song expected = testSong;
        Song actual = returned.getLast();
        assertEquals(expected, actual);
    }
    @Test
    public void searchByAlbumTest()
    {
        testServer.addSong(testSong);
        List<Song> returned= testServer.searchByAlbum("Testing");
        Song expected = testSong;
        Song actual = returned.getLast();
        assertEquals(expected, actual);
    }
}
