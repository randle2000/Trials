package com.sln.proteintracker;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.simpleprogrammer.TrackingService;

/*
 * method marked with @Parameters (method data() in our case) return a list of pairs: input values, expected value
 * A new instance of ParameterizedTests class will be created for each such pair (passing the pair as parameters to a constructor)
 * and the method marked with @Test will be run (method test() in our example)
 */

@RunWith(Parameterized.class)
public class ParameterizedTests {
	// we are using static here because we intend to apply test values subsequently to the same object (service) 
	private static TrackingService service = new TrackingService();
	private int input;
	private int expected;
	
	@Parameters
	public static List<Object[]> data() {
		return Arrays.asList(new Object[][] {	
			{5, 5},		
			{5, 10},	// after adding another 5 we expect the result to be 10
			{-12, 0},
			{50, 50},
			{1, 51}
		});
	}
	
	public ParameterizedTests(int input, int expected) {  
		this.input = input;
		this.expected = expected;
	}
	
	@Test
	public void test() {
		if (input >= 0)
			service.addProtein(input);
		else
			service.removeProtein(-input);
		assertEquals(expected, service.getTotal());
	}
}
