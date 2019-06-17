package seleniumTests;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import beckendTests.LoggerSuite;
import myCategories.*;

@RunWith(Suite.class)
@SuiteClasses({IndexTests.class,LoginTests.class,MonstersTests.class,LogTests.class,LoggerSuite.class})
@Categories.IncludeCategory({Post.class, Put.class, Get.class,Delete.class,NonCRUD.class})
public class TestSuite {
	
}
