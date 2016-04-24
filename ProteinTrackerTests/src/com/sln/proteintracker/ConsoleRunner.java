package com.sln.proteintracker;
import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;

/*
 * This file is used to run tests as standalone Java application and output results to console
 * 
 * You can also run test from command line (i.e. you don't need this ConsoleRunner class):
 * 		Suppose you have downloaded JUnit JARs (junit.jar and hamcrest-core.jar) into C:\libs\junit\
 * 		And suppose you right-clicked both projects ProteinTracker and ProteinTrackerTests and exported them into C:\Java\ProteinTracker.jar
 * 		Then you can do this:
 * 			java -cp c:\libs\junit\*;C:\Java\ProteinTracker.jar org.junit.runner.JUnitCore com.sln.proteintracker.tests.TrackingServiceTests
 */
public class ConsoleRunner {

	public static void main(String args[]) {
		JUnitCore junit = new JUnitCore();
		junit.addListener(new TextListener(System.out));
		
		junit.run(TrackingServiceTests.class);
	}
}
