package logger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Monster")
public class Monster {
	//these should be auto poulated into the database and used as a reference for the log
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	@Column(name="Monster_Name")
	private String monsterName;
	@Column(name="Rank")
	private int rank;
	@Column(name="Weaknesses")
	private String elementalWeaknesses;
	
	public int getId(){
		return id;
	}

	public void setId(int id){
		this.id = id;
	}

	public String getName(){
		return monsterName;
	}

	public void setName(String name){
		this.monsterName = name;
	}

	public int getRank(){
		return rank;
	}

	public void setRank(int rank){
		this.rank = rank;
	}

	public String getElementalWeaknesses(){
		return elementalWeaknesses;
	}

	public void setElementalWeaknesses(String weaknesses){
		this.elementalWeaknesses = weaknesses;
	}
}
