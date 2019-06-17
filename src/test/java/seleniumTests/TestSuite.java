package seleniumTests;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import myCategories.*;

@RunWith(Suite.class)
@SuiteClasses({IndexTests.class,LoginTests.class,MonstersTests.class,LogTests.class})
@Categories.IncludeCategory({Post.class, Put.class, Get.class,Delete.class,NonCRUD.class})
public class TestSuite {

}
