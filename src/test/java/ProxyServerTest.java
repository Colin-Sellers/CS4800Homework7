import Part2Proxy.ProxyServer;
import Part2Proxy.RealServer;
import Part2Proxy.Song;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class ProxyServerTest
{
    Song testSong = new Song("Test", "Tester", "Testing", 10);
    RealServer realServer = new RealServer();
    ProxyServer testServer = new ProxyServer(realServer);

    // Each test will have artificial 'latency' as proxy contacts real
    // Each test relies on proxy's cache for actual
    @Test
    public void searchByIDTest()
    {
        testServer.searchById(0); // Add into cache
        Song returned = testServer.searchById(0); // Grabbed from cache
        String expected = "Everlong"; // Auto initialized
        String actual = returned.getTitle();
        assertEquals(expected, actual);
    }
    @Test
    public void searchByTitleTest()
    {
        realServer.addSong(testSong);
        testServer.searchByTitle("Test"); // Added into cache
        List<Song> returned = testServer.searchByTitle("Test"); // Grabbed from cache
        Song expected = testSong;
        Song actual = returned.getLast();
        assertEquals(expected, actual);
    }
    @Test
    public void SearchByAlbumTest()
    {
        realServer.addSong(testSong);
        testServer.searchByAlbum("Testing"); // Added into cache
        List<Song> returned = testServer.searchByAlbum("Testing"); // Grabbed from cache
        Song expected = testSong;
        Song actual = returned.getLast();
        assertEquals(expected, actual);
    }
}
