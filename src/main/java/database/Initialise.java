package database;

public final class Initialise {

	public String createUserTable() {
		String returnValue = "create table user (uid int, name varchar(50), primary key(uid))";
		return returnValue;
	}
	
	public String createMonsterTable() {
		String returnValue = "create table monster (uid int, name varchar(50), rank int, fire_res int, water_res int, lightning_res int,"
				+ "ice_res int, dragon_res int, primary key(uid))";
		return returnValue;
	}
	
	
	
}
