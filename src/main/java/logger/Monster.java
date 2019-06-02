package logger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Monster {
	//these should be auto poulated into the database and used as a reference for the log
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	@Column(name="Monster")
	private String monsterName;
	@Column(name="Rank")
	private int rank;
	@Column(name="Weaknesses")
	private String elementalWeaknesses;
	
}
