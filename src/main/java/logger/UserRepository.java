package logger;

import java.util.List;

public interface UserRepository {

	public User createUser(User user);
	
	public User getUser(int id);
	public User getUser(String name);
	public User getUser(User user);
	public List<User> getAllUsers();
	public void deleteUser(int id);
	public void deleteUser(String name);
	public User updateUser(String oldName, String newName);
	
}
