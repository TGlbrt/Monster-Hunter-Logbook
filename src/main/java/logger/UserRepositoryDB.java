package logger;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

@Transactional(value = TxType.SUPPORTS)
public class UserRepositoryDB implements UserRepository{
	//@PersistenceUnit
	//private EntityManagerFactory emf;
	@PersistenceContext(unitName = "myPU")
	private EntityManager manager;// = emf.createEntityManager();
	
	@Transactional(value = TxType.REQUIRED)
	public User createUser(User user) {
		
		//EntityTransaction et = manager.getTransaction();
		//et.begin();
		manager.persist(user);
		//et.commit();
		//manager.close();
		return user;
		//return getUser(user.getId());
	}
	
	public User getUser(int id) {
		//EntityManager manager = emf.createEntityManager();
		User user = manager.find(User.class,id);
		return user;
	}

	public User getUser(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public User getUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}
}
