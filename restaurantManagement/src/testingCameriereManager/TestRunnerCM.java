package testingCameriereManager;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import testingMenù.TestSuiteMBD;

public class TestRunnerCM {

	public static void main(String[] args) {
		
		Result result = JUnitCore.runClasses(TestSuiteCM.class);

	    for (Failure failure : result.getFailures()) {
	      System.out.println(failure.toString());
	    }

	    System.out.println(result.wasSuccessful());
	  }

}