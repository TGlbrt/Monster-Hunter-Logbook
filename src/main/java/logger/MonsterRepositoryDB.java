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
        Monster returnedMonster = new Monster();
        for(Monster monster : allMonster){
            if(monster.getName().equals(name)){
                returnedMonster = monster;
            }
        }
        return returnedMonster;
    }

    public Monster getMonster(String name, int rank){
        List<Monster> allMonster = getAllMonsters();
        Monster returnedMonster = new Monster();
        for(Monster monster : allMonster){
            if(monster.getName().equals(name)){
                if(monster.getRank() == (rank)){
                    returnedMonster = monster;
                }
            }
        }
        return returnedMonster;
    }

    public Monster getMonster(Monster monster) {
        Monster foundMonster = manager.find(Monster.class, monster.getId());
        return foundMonster;
    }

    public List<Monster> getAllMonsters() {
        List<Monster> allMonsters = new ArrayList<Monster>();
        TypedQuery<Monster> getAllQuery = manager.createQuery("SELECT monster FROM Monster monster",Monster.class);
        //allMonsters = manager.createQuery("SELECT monsters FROM MONSTER monsters",Monster.class).getResultList();
        allMonsters = getAllQuery.getResultList();
        return allMonsters;
    }

    @Transactional(value = TxType.REQUIRED)
    public void deleteMonster(int id) {
        manager.remove(getMonster(id));
    }

    @Transactional(value = TxType.REQUIRED)
    public void deleteMonster(String name) {
        deleteMonster(getMonster(name).getId());
    }

    @Transactional(value = TxType.REQUIRED)
    public void deleteMonsters() {
        List<Monster> allMonsters = getAllMonsters();
        for(Monster monster : allMonsters){
            manager.remove(monster);
        }
    }

    @Transactional(value = TxType.REQUIRED)
    public Monster updateMonster(Monster monster, int id) {
        Monster foundMonster = getMonster(id);
        foundMonster.setName(monster.getName());
        foundMonster.setRank(monster.getRank());
        foundMonster.setElementalWeaknesses(monster.getElementalWeaknesses());
        return getMonster(id);
    }

}