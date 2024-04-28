import Part2Proxy.Song;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class SongTest
{
    Song testSong = new Song("Test","Testers","Testing", 10);
    @Test
    public void getTitleTest()
    {
        String expected = "Test";
        String actual = testSong.getTitle();
        assertEquals(expected, actual);
    }
    @Test
    public void getArtistTest()
    {
        String expected = "Testers";
        String actual = testSong.getArtist();
        assertEquals(expected, actual);
    }
    @Test
    public void getAlbumTest()
    {
        String expected = "Testing";
        String actual = testSong.getAlbum();
        assertEquals(expected, actual);
    }
    @Test
    public void getDurationTest()
    {
        int expected = 10;
        int actual = testSong.getDuration();
        assertEquals(expected, actual);
    }
}
