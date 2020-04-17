package Util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUtil {
	private EntityManagerFactory emfactory = null;
	private static PersistenceUtil instance;
	
	public EntityManagerFactory getEMFactory() {
		return emfactory;
	}
	private PersistenceUtil() {
		emfactory = Persistence.createEntityManagerFactory("jpa_eclipselink");
	}
	public static PersistenceUtil getInstance() {
		if (null == instance)
			instance = new PersistenceUtil();
		return instance;
	}
}
