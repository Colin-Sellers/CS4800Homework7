package Part2Proxy;

public class Song
{
    private final String title;
    private final String artist;
    private final String album;
    private final int duration;

    public Song(String title, String artist, String album, int duration)
    {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.duration = duration;
    }

    public String getTitle()
    {
        return title;
    }

    public String getArtist()
    {
        return artist;
    }

    public String getAlbum()
    {
        return album;
    }

    public int getDuration()
    {
        return duration;
    }
}
