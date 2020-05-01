package Util;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * PersistenceUtil class creates and returns an EntityManagerFacory object 
 *
 */
public class PersistenceUtil {
	
	private EntityManagerFactory entity_manager_factory = null;
	private static PersistenceUtil instance;
	
	public EntityManagerFactory getEMFactory() {
		
		return entity_manager_factory;
	}
	
	private PersistenceUtil() {
		
		entity_manager_factory = Persistence.createEntityManagerFactory("MusicAlbumsPU");
	}
	
	public static PersistenceUtil getInstance() {
		
		if (null == instance)
			instance = new PersistenceUtil();
		return instance;
	}
}
