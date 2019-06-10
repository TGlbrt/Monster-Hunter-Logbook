package logger;

import java.util.List;

public interface UserRepository {

	public User createUser(User user);
	
	public User getUser(int id);
	public User getUser(String name);
	public User getUser(User user);
	public List<User> getAllUsers();
	
}
