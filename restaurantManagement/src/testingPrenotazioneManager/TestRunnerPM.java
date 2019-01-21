package testingPrenotazioneManager;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import testingUtente.TestSuiteUBD;

public class TestRunnerPM {

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(TestSuiteUBD.class);

	    for (Failure failure : result.getFailures()) {
	    	System.out.println(failure.toString());
	    }

	    System.out.println(result.wasSuccessful());
	}

}
