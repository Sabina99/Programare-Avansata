package App;

import java.util.List;
import Entity.Album;
import Entity.Artist;
import Repo.AlbumRepository;
import Repo.ArtistRepository;

/**
 * 
 * AlbumManager class is used to test the application, all the methods created
 *
 */
public class AlbumManager {
	
	private static List<Artist> artists;
	private static List<Album> albums;
	
	/**
	 * uses the methods created and shows the result on the screen
	 * @param args
	 */
	public static void main(String[] args) {
		
		addToTable();
		
		System.out.println("THE ARTIST WITH ID 1 IS: ");
		System.out.println(ArtistRepository.findById(1));
		
		System.out.println("THE ARTISTS WITH NAME STARTING WITH THE LETTER T: ");
		artists = ArtistRepository.findByName("M%");
		
		System.out.println("THE FIRST ALBUM IS: ");
		System.out.println(AlbumRepository.findById(1));
		
		System.out.println("THE ALBUMS THAT END IN THE LETTER E: ");
		albums = AlbumRepository.findByName("%E");	
		
	}
	
	/**
	 * addToTable method adds data to the Tables
	 * 
	 */
	private static void addToTable() {
		int artistID = 1, albumID = 1;
		Artist artist1;
		artist1 = new Artist(artistID++, "The Fratellis", "Scotland");
		ArtistRepository.create(artist1);
		Artist artist2;
		artist2 = new Artist(artistID++, "alt-J", "USA");
		ArtistRepository.create(artist2);
		

		AlbumRepository.create(new Album(albumID++, "Here We Stand", 2008, artist1));
		AlbumRepository.create(new Album(albumID++, "In your own sweet time", 2018, artist1));
		AlbumRepository.create(new Album(albumID++, "An Awesome Wave", 2012, artist2));
		AlbumRepository.create(new Album(albumID++, "This Is All Yours", 2014, artist2));
		AlbumRepository.create(new Album(albumID++, "Relaxer", 2017, artist2));
	}

}
