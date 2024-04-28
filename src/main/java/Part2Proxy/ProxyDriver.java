package Part2Proxy;

import java.util.List;

public class ProxyDriver
{
    public static void main(String[] args)
    {
        SongService realServer = new RealServer();
        SongService proxyServer = new ProxyServer(realServer);

        // Test search by id
        System.out.println("Searching by ID:\n\nID 1:");
        printSong(proxyServer.searchById(1));

        System.out.println("\nID 2:");
        printSong(proxyServer.searchById(2));

        System.out.println("\nID 3:");
        printSong(proxyServer.searchById(3));

        System.out.println("\nID 2:");
        printSong(proxyServer.searchById(2));

        System.out.println("\nID 1:");
        printSong(proxyServer.searchById(1));

        // Error Case
        System.out.println("\nID 500:");
        printSong(proxyServer.searchById(500));

        // Test search by title
        System.out.println("\n\nSearching by title:\n\nSearching for \"Walk\"");
        printListOfSongs(proxyServer.searchByTitle("Walk"));

        System.out.println("\nSearching for \"Smells like Teen Spirit\"");
        printListOfSongs(proxyServer.searchByTitle("Smells like Teen Spirit"));

        System.out.println("\nSearching for \"One\"");
        printListOfSongs(proxyServer.searchByTitle("One"));

        System.out.println("\nSearching for \"Walk\"");
        printListOfSongs(proxyServer.searchByTitle("Walk"));

        System.out.println("\nSearching for \"One\"");
        printListOfSongs(proxyServer.searchByTitle("One"));

        // Error Case
        System.out.println("\nSearching for \"Something\"");
        printListOfSongs(proxyServer.searchByTitle("Something"));

        // Test search by album
        System.out.println("\n\nSearching by Album:\n\nSearching for \"Colour and the Shape\"");
        printListOfSongs(proxyServer.searchByAlbum("Colour and the Shape"));

        System.out.println("\nSearching for \"And Justice for All\"");
        printListOfSongs(proxyServer.searchByAlbum("And Justice for All"));

        System.out.println("\nSearching for \"Nevermind\"");
        printListOfSongs(proxyServer.searchByAlbum("Nevermind"));

        System.out.println("\nSearching for \"And Justice for All\"");
        printListOfSongs(proxyServer.searchByAlbum("And Justice for All"));

        System.out.println("\nSearching for \"Colour and the Shape\"");
        printListOfSongs(proxyServer.searchByAlbum("Colour and the Shape"));

        // Error Case
        System.out.println("\nSearching for \"NoSuchAlbum\"");
        printListOfSongs(proxyServer.searchByAlbum("NoSuchAlbum"));
    }

    private static void printSong(Song thisSong)
    {
        if (thisSong == null)
        {
            System.out.println("Error, this song does not exist!");
        }
        else
        {
            System.out.println("Song: " + thisSong.getTitle() + " | By: " + thisSong.getArtist()
                    + " | From: " + thisSong.getAlbum() + " | Length: " + thisSong.getDuration() + " seconds.");
        }
    }

    private static void printListOfSongs(List<Song> theseSongs)
    {
        if(theseSongs.isEmpty())
        {
            System.out.println("Error, could not find what you were searching for!");
        }
        else
        {
            for(Song thisSong : theseSongs)
            {
                printSong(thisSong);
            }
        }
    }
}
