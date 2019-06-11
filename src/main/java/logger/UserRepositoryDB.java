package logger;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

public class UserRepositoryDB implements UserRepository{
	@PersistenceUnit
	private EntityManagerFactory emf;
	
	public User createUser(User user) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction et = manager.getTransaction();
		et.begin();
		manager.persist(user);
		et.commit();
		manager.close();
		return getUser(user.getId());
	}
	
	public User getUser(int id) {
		EntityManager manager = emf.createEntityManager();
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
