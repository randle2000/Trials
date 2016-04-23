import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

import org.junit.Assume;

import com.simpleprogrammer.TrackingService;

/*
 * Theory is like a Parameterized test. 
 * @Theory method will use a single parameter of any data type and will use that as input for the test
 * But the difference between a theory and a Parameterized test is that a theory will have the same 
 * expected result for all inputs (under some assumptions)  
 */

@RunWith(Theories.class)
public class TrackingServiceTheories {
	
	// you make this static method that holds input values
	@DataPoints
	public static int[] data() {
		return new int[] {1, 5, 10, 15, 20, 50, -4};
	}
	
	// this method will subsequently receive all input values above as a parameter 
	@Theory
	public void PositiveValuesShouldAlwaysHavePositiveTotals(int value) {
		TrackingService service = new TrackingService();
		service.addProtein(value);
		
		Assume.assumeTrue(value > 0);		// negative input value -4 will be skipped 
		assertTrue(service.getTotal() > 0);
	}

}
