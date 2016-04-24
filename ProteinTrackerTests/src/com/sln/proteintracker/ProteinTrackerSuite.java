package com.sln.proteintracker;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/*
 * Suites are used to run tests for several classes
 */
@RunWith(Suite.class)	
@Suite.SuiteClasses({		// you just list the classes for which you want to run the tests
	HelloJUnitTest.class, 
	TrackingServiceTests.class
})
public class ProteinTrackerSuite {

}
