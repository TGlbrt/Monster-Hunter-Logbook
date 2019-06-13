package logger;

import java.util.List;

public interface LoggerRepository {

	//create
	public Log createLog(Log log);
	//read one
	public Log getLog(int id);
	//read many
	public List<Log> getAllUserLogs(String username);
	public List<Log> getUserLogsByMonster(String userName,String monsterName);
	//update
	public Log changeTime(int id, Log log);
	//delete
	public void removeLog(int id);
	
}
