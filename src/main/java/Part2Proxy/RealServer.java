package Part2Proxy;

import java.util.ArrayList;
import java.util.List;

public class RealServer implements SongService
{
    List<Song> storedSongs;

    public RealServer()
    {
        storedSongs = new ArrayList<>();
        addTestSongs(); // Initialization by adding some test songs
    }

    public void addSong(Song newSong)
    {
        storedSongs.add(newSong);
        System.out.println("Song " + newSong.getTitle() + " by: "
                + newSong.getArtist() + " added, id assigned as: " + (storedSongs.size() - 1)); // Id 0 exists
    }

    @Override
    public Song searchById(Integer songID)
    {
        networkLatency();
        try
        {
            return storedSongs.get(songID);
        }
        catch (IndexOutOfBoundsException e)
        {
            // Song ID does not exist!
            return null;
        }
    }

    @Override
    public List<Song> searchByTitle(String title)
    {
        networkLatency();
        List<Song> songsByTitle = new ArrayList<>();
        for (Song thisSong : storedSongs)
        {
            if (thisSong.getTitle().equalsIgnoreCase(title))
            {
                songsByTitle.add(thisSong);
            }
        }
        return songsByTitle;
    }

    @Override
    public List<Song> searchByAlbum(String album)
    {
        networkLatency();
        List<Song> songsByAlbum = new ArrayList<>();
        for (Song thisSong : storedSongs)
        {
            if (thisSong.getAlbum().equalsIgnoreCase(album))
            {
                songsByAlbum.add(thisSong);
            }
        }
        return songsByAlbum;
    }

    private void networkLatency()
    {
        // Simulate networkLatency by adding a 1-second delay
        try
        {
            Thread.sleep(1000);
            System.out.println("~Request to Real Server~"); // Display to show if request is from proxy or real server
        }
        catch (Exception e)
        {
            System.err.println("There was an error with sleep: " + e.getMessage());
        }
    }

    private void addTestSongs()
    {
        addSong(new Song("Everlong","Foo Fighters","Colour and the Shape",251));
        addSong(new Song("Monkey Wrench","Foo Fighters","Colour and the Shape",232));
        addSong(new Song("Walk","Foo Fighters","Wasting Light",256));
        addSong(new Song("Smells like Teen Spirit","Nirvana","Nevermind",279));
        addSong(new Song("Breed","Nirvana","Nevermind",184));

        addSong(new Song("Sugar","System of a Down","System of a Down",155));
        addSong(new Song("Walk","Pantera","Vulgar Display of Power",320));
        addSong(new Song("My Hero","Foo Fighter","Colour and the Shape",260));
        addSong(new Song("Enter Sandman","Metallica","Black",332));
        addSong(new Song("One","Metallica","And Justice for All",446));
    }
}
