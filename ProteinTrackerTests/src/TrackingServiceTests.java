import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.simpleprogrammer.InvalidGoalException;
import com.simpleprogrammer.TrackingService;

public class TrackingServiceTests {
	private TrackingService service;
	
	@BeforeClass			
	public static void before() {		// this is run once; must be static 
		System.out.println("Before Class");
	}

	@AfterClass			
	public static void after() {		// this is run once; must be static 
		System.out.println("After Class");
	}
	
	@Before
	public void setUp() {	// this is run each time before each test method
		System.out.println("Before");
		service = new TrackingService();
	}

	@After			// Usually @After is used much less often than @Before
	public void tearDown() {	// it's a convention to call this method tearDown but you can call whatever you want
		System.out.println("After");
	}
	
	
	@Test
	public void NewTrackingServiceTotalIsZero() {
		assertEquals("Tracking service total was not 0", 0, service.getTotal());
	}

	@Test
	@Ignore		// to skip this test
	public void WhenAddingProteinTotalIncreasesByThatAmount() {
		TrackingService service = new TrackingService();
		service.addProtein(10);
		assertEquals(10, service.getTotal());
	}

	@Test
	public void WhenRemovingProteinTotalRemainsZero() {
		TrackingService service = new TrackingService();
		service.removeProtein(5);
		assertEquals(0, service.getTotal());
	}
	
	@Test(expected = InvalidGoalException.class)
	public void WhenGoalIsSetToLessThanZeroExceptionIsThrown() throws InvalidGoalException {
		service.setGoal(-5);
	}
	
	@Test(timeout = 200)	// this test will fail if it does not finish in 200 ms
	public void BadTest() {
		for (int i = 0; i < 10000000; i++)
			service.addProtein(1);
	}
}
