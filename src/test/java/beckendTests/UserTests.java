package beckendTests;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.client.*;
import javax.ws.rs.container.*;
import javax.ws.rs.core.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runners.Parameterized.Parameters;

import rest.UserEndpoints;
import logger.User;
import logger.UserRepository;
import logger.UserRepositoryDB;

public class UserTests {	
	
	User testUser;
	UserRepositoryDB userTestRepoDB;
	
	@Before
	public void setup() {
		testUser = new User();
		testUser.setId(0);
		testUser.setUsername("JUnitTest");
		testUser.setPassword("JUnitTestPass");
	}
	
	
	  @Category(PostTest.class)
	  @Test
	  public void createUser() {
		 String username = testUser.getUsername();
		 String password = testUser.getPassword();
	  }
}
