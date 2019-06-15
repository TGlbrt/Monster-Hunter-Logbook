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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

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
	@PersistenceContext(unitName = "myPU")
	private EntityManager manager;
	
	static UserRepository userRepo;
	static UserRepositoryDB userRepoDB;
	static User testUser;
	
    private static EntityManager em;
    private static EntityTransaction tx;
    
	@Inject
	UserRepository userTestRepo;
	
	@BeforeClass
	public static void startup() {
        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPU");
        //em = emf.createEntityManager();
        //tx = em.getTransaction();
		
		
		//testUser = new User(); testUser.setUsername("JUnitTest");
		//testUser.setPassword("testJUnit"); userRepoDB = new UserRepositoryDB();
		 
	}
	
	@Before
	public void setup() {
		this.em = Persistence.createEntityManagerFactory("myPU")
                .createEntityManager();
		this.tx = this.em.getTransaction();
	}
	
	@After
	public void teardown() {
		em.clear();
		em.close();
		
	}
	
	/*
	 * @Category(PostTest.class)
	 * 
	 * @Inject UserRepository testUserRepoTwo;
	 * 
	 * @Path("api/user/")
	 * 
	 * @Parameters
	 * 
	 * @Test public void createUser(User testUser,@Context UriInfo uriInfo) {
	 * //testUserEndpoints = new UserEndpoints(); Response testResponse =
	 * testUserEndpoints.createUser(testUser, uriInfo); String testPath =
	 * testResponse.getLocation().getPath(); System.out.println("testPath : " +
	 * testPath);
	 * 
	 * }
	 */
	
	  @Category(PostTest.class)
	  @Test
	  @Transactional
	  public void createUserTwo() {
		  testUser = new User();
		  testUser.setUsername("JUnitTest");
		  testUser.setPassword("testJUnit"); 
		  tx.begin();
		  em.persist(testUser);
		  tx.commit();
		  //userRepo = (UserRepositoryDB) userRepo;
		  //User returnedUser = userRepo.createUser(testUser);
		  //User returnedUser = testUserRepo.createUser(testUser);
		  //System.out.println(returnedUser.getId());
	  }
}
