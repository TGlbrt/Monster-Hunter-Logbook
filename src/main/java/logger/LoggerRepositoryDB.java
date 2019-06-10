package logger;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

public class LoggerRepositoryDB implements LoggerRepository{
	@PersistenceContext(unitName = "myPU")
	private EntityManagerFactory emf;

	public Log createLog(Log log) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction et = manager.getTransaction();
		et.begin();
		manager.persist(log);
		et.commit();
		manager.close();
		return getLog(log.getId());
	}

	public Log getLog(int id) {
		EntityManager manager = emf.createEntityManager();
		Log log = manager.find(Log.class,id);
		return log;
	}

	public List<Log> getAllUserLogs(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Log> getUserLogsByMonster(String userName, String monsterName) {
		// TODO Auto-generated method stub
		return null;
	}

	public Log changeTime(int id, String time) {
		// TODO Auto-generated method stub
		return null;
	}

	public void removeAccount(int id) {
		// TODO Auto-generated method stub
		
	}
	
}
