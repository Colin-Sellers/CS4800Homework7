package Part2Proxy;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class ProxyServer implements SongService
{
    private final SongService hostServer;
    // Songs must be stored as Maps, Otherwise proxy may not have all songs part of title / album / same id
    Map<Integer, Song> songIDCache;
    Map<String, List<Song>> songTitleCache;
    Map<String, List<Song>> songAlbumCache;

    // Host server could be another proxy
    public ProxyServer(SongService hostServer)
    {
        this.hostServer = hostServer;
        songIDCache = new HashMap<>();
        songTitleCache = new HashMap<>();
        songAlbumCache = new HashMap<>();
    }

    @Override
    public Song searchById(Integer songID)
    {
        if (songIDCache.containsKey(songID))
        {
            return songIDCache.get(songID);
        }
        Song searched= hostServer.searchById(songID);
        if (!(searched == null))
        {
            songIDCache.put(songID, searched);
            return searched;
        }
        return null;
    }

    @Override
    public List<Song> searchByTitle(String title)
    {
        if (songTitleCache.containsKey(title))
        {
            return songTitleCache.get(title);
        }
        List<Song> searched = hostServer.searchByTitle(title);
        // Don't store incorrect / invalid searches
        if (!searched.isEmpty())
        {
            songTitleCache.put(title, searched);
        }
        return searched;
    }

    @Override
    public List<Song> searchByAlbum(String album)
    {
        if (songAlbumCache.containsKey(album))
        {
            return songAlbumCache.get(album);
        }
        List<Song> searched = hostServer.searchByAlbum(album);
        // Don't store incorrect / invalid searches
        if (!searched.isEmpty())
        {
            songAlbumCache.put(album, searched);
        }
        return searched;
    }
}
