package logger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Log {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	@Column(name="Name")//foriegn key for user account
	private String userName;
	@Column(name="Monster")//foriegn key for monster
	private String monsterName;
	@Column(name="Time")
	private String time;//String for now mm:ss:ms
	@Column(name="number_of_players")
	
	private int noOfPlayers;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getMonsterName() {
		return monsterName;
	}
	
	public void setMonsterName(String monsterName) {
		this.monsterName = monsterName;
	}
	
	public String getTime() {
		return time;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
	public int getNumberOfPlayers() {
		return noOfPlayers;
	}
	
	public void setNumberOfPlayers(int noOfPlayers) {
		this.noOfPlayers = noOfPlayers;
	}
}
