package logger;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

@Transactional(value = TxType.SUPPORTS)
public class LoggerRepositoryDB implements LoggerRepository{ 
	@PersistenceContext(unitName = "myPU")
    private EntityManager manager;

	@Transactional(value = TxType.REQUIRED)
	public Log createLog(Log log) {
		manager.persist(log);
		return getLog(log.getId());
	}

	public Log getLog(int id) {
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
        allLogs = getAllLogs();
		List<Log> allUserMonsterLogs = new ArrayList<Log>();
		for(Log log : allLogs){
			if(log.getMonsterName().equals(monsterName) && log.getUserName().equals(userName)){
				allUserMonsterLogs.add(log);
			}
		}
		return allUserMonsterLogs;
	}

	@Transactional(value = TxType.REQUIRED)
	public Log changeExistingLog(int id, Log log) {
		Log oldLog = getLog(id);
		oldLog.setMonsterName(log.getMonsterName());
		oldLog.setNumberOfPlayers(log.getNumberOfPlayers());
		oldLog.setTime(log.getTime());
		return getLog(id);
	}

	@Transactional(value = TxType.REQUIRED)
	public void removeLog(int id) {
		manager.remove(id);
		
	}
	
}
