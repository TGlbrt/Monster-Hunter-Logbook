package logger;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

public class LoggerRepositoryDB implements LoggerRepository{ 
	@PersistenceContext(unitName = "myPU")

	private EntityManagerFactory emf;

	@Transactional(value = TxType.REQUIRED)
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

	private List<Log> getAllLogs(){
		List<Log> allLogs = new ArrayList<Log>();
        TypedQuery<Log> getAllQuery = manager.createQuery("SELECT log FROM Log log",Log.class);
        allLogs = getAllQuery.getResultList();
		return allLogs;
	}

	public List<Log> getAllUserLogs(String username) {
        List<Log> allLogs = new ArrayList<Log>();
		allLogs = getAllLogs();
		List<Log> allUserLogs = new ArrayList<Log>();
		for(Log log : allLogs){
			if(log.getUserName().equals(username)){
				allUserLogs.add(log);
			}
		}
		return allUserLogs;
	}
	
	public List<Log> getUserLogsByMonster(String userName, String monsterName) {
		List<Log> allLogs = new ArrayList<Log>();
        allLogs = getAllLogs;
		List<Log> allUserMonsterLogs = new ArrayList<Log>();
		for(Log log : allLogs){
			if(log.getMonsterName().equals(monsterName) && log.getUserName().equals(userName)){
				allUserMonsterLogs.add(log);
			}
		}
		return allUserMonsterLogs;
	}

	@Transactional(value = TxType.REQUIRED)
	public Log changeTime(int id, Log log) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(value = TxType.REQUIRED)
	public void removeLog(int id) {
		// TODO Auto-generated method stub
		
	}
	
}
