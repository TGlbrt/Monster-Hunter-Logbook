package logger;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

@Transactional(value = TxType.SUPPORTS)
public class MonsterRepositoryDB implements MonsterRepository {
    @PersistenceContext(unitName = "myPU")
    private EntityManager manager;// = emf.createEntityManager();

    @Transactional(value = TxType.REQUIRED)
    public Monster createMonsterEntry(Monster monster) {
        manager.persist(monster);
        return getMonster(monster.getId());
    }

    public Monster getMonster(int id) {
        Monster monster = manager.find(Monster.class,id);
        return monster;
    }

    public Monster getMonster(String name) {
        List<Monster> allMonster = getAllMonsters();
        for(Monster monster : allMonster){
            if(monster.getName().equals(name)){
                return monster;
            }
        }
        return null;
    }

    public Monster getMonster(Monster monster) {
        Monster foundMonster = manager.find(Monster.class, monster.getId());
        return foundMonster;
    }

    public List<Monster> getAllMonsters() {
        List<Monster> allMonsters = new ArrayList<Monster>();
        allMonsters = manager.createQuery("SELECT monster FROM MONSTER monster",Monster.class).getResultList();
        return allMonsters;
    }

    public void deleteMonster(int id) {
        manager.remove(getMonster(id));
    }

    public void deleteMonster(String name) {
        deleteMonster(getMonster(name).getId());
    }

    public void deleteMonsters() {
        List<Monster> allMonsters = getAllMonsters();
        for(Monster monster : allMonsters){
            manager.remove(monster);
        }
    }

    public Monster updateMonster(Monster monster, int id) {
        Monster foundMonster = getMonster(id);
        foundMonster.setName(monster.getName());
        foundMonster.setRank(monster.getRank());
        foundMonster.setElementalWeaknesses(monster.getElementalWeaknesses());
        return getMonster(id);
    }

}