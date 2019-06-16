package seleniumTests;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class Runner {
	public static void main(String args[]) {
		Result results = JUnitCore.runClasses(TestSuite.class);
		System.out.println(results.getFailureCount());
	}
}
