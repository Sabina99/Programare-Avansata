package Repo;
import java.util.List;

import Entity.Artist;
import Util.PersistenceUtil;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 * The class ArtistRepository manages the table artist
 *
 */
public class ArtistRepository {
	
	/**
	 * create method receives data and adds it to the table
	 * @param album
	 */
	public static void create(Artist artist){
		
		EntityManagerFactory entity_manager_factory = PersistenceUtil.getInstance().getEMFactory();
		EntityManager entity_manager = entity_manager_factory.createEntityManager();
	    entity_manager.getTransaction().begin();
		
	    entity_manager.persist(artist);
	    entity_manager.getTransaction().commit();
	    entity_manager.close();
	}
	
	/**
	 * findById method receives the ID of an artist as a parameter and returns the artist with that specific ID
	 * @param id
	 * @return
	 */
	public static Artist findById(int id){
		
		EntityManagerFactory entity_manager_factory = PersistenceUtil.getInstance().getEMFactory();
		EntityManager entity_manager = entity_manager_factory.createEntityManager();
		Artist artist = entity_manager.find(Artist.class, id);
		entity_manager.close();
		
		return artist;
	}

	/**
	 *  findByName method receives the name of an artist as a parameter and returns the artist with that specific name
	 * 
	 * @param name
	 * @return
	 */
	public static List<Artist> findByName(String name){
		EntityManagerFactory etity_manager_factory = PersistenceUtil.getInstance().getEMFactory();
		EntityManager entity_manager = etity_manager_factory.createEntityManager();
		Query query = entity_manager.createQuery(String.format("SELECT e FROM Artist e WHERE e.name LIKE '%e%'", name));
		List<Artist> list_of_artists = (List<Artist>) query.getResultList(); 
		entity_manager.close();
		
		return list_of_artists;
	}
}