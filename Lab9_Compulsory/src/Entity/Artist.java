package Entity;
import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the artists database table.
 * 
 */
@Entity
@Table(name="artists")

public class Artist implements Serializable {

	@Id
	private int id;

	private String country;

	private String name;

	private List<Album> albums;

	private static final long serialVersionUID = 1L;

	public Artist() {
	}
	
	public Artist(String country, String name) {
		super();
		this.country = country;
		this.name = name;
	}

	public Artist(int id, String country, String name) {
		super();
		this.id = id;
		this.country = country;
		this.name = name;
	}


	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Album> getAlbums() {
		return this.albums;
	}

	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}

	public Album addAlbum(Album album) {
		getAlbums().add(album);
		album.setArtist(this);

		return album;
	}

	public Album removeAlbum(Album album) {
		getAlbums().remove(album);
		album.setArtist(null);
		return album;
	}

	@Override
	public String toString() {
		return "Artist [id=" + id + ", country=" + country + ", name=" + name + ", albums=" + albums + "]";
	}
	

}