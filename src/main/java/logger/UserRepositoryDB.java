package logger;

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

@Transactional(value = TxType.SUPPORTS)
public class UserRepositoryDB implements UserRepository{
	//@PersistenceUnit
	//private EntityManagerFactory emf;
	@PersistenceContext(unitName = "myPU")
	private EntityManager manager;// = emf.createEntityManager();
	
	@Transactional(value = TxType.REQUIRED)
	public User createUser(User user) {
		manager.persist(user);
		return user;
	}
	
	public User getUser(int id) {
		//EntityManager manager = emf.createEntityManager();
		User user = manager.find(User.class,id);
		return user;
	}

	public User getUser(String name) {
		List<User> users = getAllUsers();
		User user = new User();
		for(int i = 0;i<users.size();i++){
			if(users.get(i).getUsername().equals(name)){
				user = users.get(i);
			}
		}
		System.out.println(user);
		return user;
	}

	public User getUser(User user) {
		User retUser = manager.find(User.class,user);
		return retUser;
	}

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		//users = manager.createQuery("FROM User",User.class).getResultList();
		users = manager.createQuery("SELECT user FROM User user",User.class).getResultList();//more readable
		System.out.println("users " + users);
		return users;
	}

	@Transactional(value = TxType.REQUIRED)
	public void deleteUser(int id) {
		System.out.println("delete by id : " + id);
		manager.remove(manager.find(User.class,id));
	}
	
	@Transactional(value = TxType.REQUIRED)
	public void deleteUsers() {
		for(int i = 0;i < 100;i++) {
			if(manager.find(User.class,i) != null) {
				manager.remove(getUser("test"));
			}
		}
	}

	@Transactional(value = TxType.REQUIRED)
	public void deleteUser(String name) {
		System.out.println("delete by name : " + name);
		manager.remove(getUser(name).getId());
	}

	@Transactional(value = TxType.REQUIRED)
	public User updateUser(User user, int id) {
		User oldUser = getUser(id);
		oldUser.setUsername(user.getUsername());
		//manager.merge(user);
		return manager.find(User.class, oldUser.getId());
	}
}
