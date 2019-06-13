package logger;

import java.util.List;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

public class MonsterRepositoryDB implements MonsterRepository {
    @PersistenceContext(unitName = "myPU")
    private EntityManager manager;// = emf.createEntityManager();

    @Transactional(value = TxType.REQUIRED)
    public Monster createMonsterEntry(Monster monster) {
        manager.persist(monster);
        return getMonster(monster.getId());
    }

    @Override
    public Monster getMonster(int id) {
        return null;
    }

    @Override
    public Monster getMonster(String name) {
        return null;
    }

    @Override
    public Monster getMonster(Monster monster) {
        return null;
    }

    @Override
    public List<Monster> getAllMonsters() {
        return null;
    }

    @Override
    public void deleteMonster(int id) {

    }

    @Override
    public void deleteMonster(String name) {

    }

    @Override
    public void deleteMonsters() {

    }

    @Override
    public User updateMonster(Monster monster, int id) {
        return null;
    }

}