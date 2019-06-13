package logger;

import java.util.List;

public interface MonsterRepository{
    public Monster createMonsterEntry(Monster monster);
	public Monster getMonster(int id);
	public Monster getMonster(String name);
	public Monster getMonster(Monster monster);
	public List<Monster> getAllMonsters();
	public void deleteMonster(int id);
	public void deleteMonster(String name);
	public void deleteMonsters();
	public User updateMonster(Monster monster, int id);
}