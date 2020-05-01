package Repo;
import java.util.List;

import Entity.Album;
import Util.PersistenceUtil;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 * 
 * The class AlbumRepository manages the table album
 *
 */
public class AlbumRepository {
	
	/**
	 * create method receives data and adds it to the table
	 * @param album
	 */
	public static void create(Album album){
		
		EntityManagerFactory emfactory = PersistenceUtil.getInstance().getEMFactory();
		EntityManager entitymanager = emfactory.createEntityManager();
	    entitymanager.getTransaction().begin();
		
	    entitymanager.persist(album);
	    entitymanager.getTransaction().commit();
	    entitymanager.close();
	}
	
	/**
	 * findById method receives the ID of an album as a parameter and returns the album with that specific ID
	 * @param id
	 * @return
	 */
	public static Album findById(int id){
		
		EntityManagerFactory emfactory = PersistenceUtil.getInstance().getEMFactory();
		EntityManager entitymanager = emfactory.createEntityManager();
		Album album = entitymanager.find(Album.class, id);
		entitymanager.close();
		return album;
	}
	
	/**
	 *  findByName method receives the name of an album as a parameter and returns the album with that specific name
	 * 
	 * @param name
	 * @return
	 */
	public static List<Album> findByName(String name){
		
		EntityManagerFactory entity_manager_factory = PersistenceUtil.getInstance().getEMFactory();
		EntityManager entity_manager = entity_manager_factory.createEntityManager();
		Query query = entity_manager.createQuery(String.format("SELECT e FROM Album e WHERE e.name LIKE '%e%'", name));
		List<Album> list_of_albums = (List<Album>)query.getResultList(); 
		entity_manager.close();
		return list_of_albums;
		
	}
}
