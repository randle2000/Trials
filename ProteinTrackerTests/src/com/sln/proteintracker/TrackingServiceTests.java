package com.sln.proteintracker;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

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
	@Category({GoodTestsCategory.class, BadCategory.class})	// this is just to mark that this test belongs to this category 
	public void NewTrackingServiceTotalIsZero() {
		assertEquals("Tracking service total was not 0", 0, service.getTotal());
	}

	@Test
	//@Ignore		// to skip this test
	@Category(GoodTestsCategory.class)	// this is just to mark that this test belongs to this category 
	public void WhenAddingProteinTotalIncreasesByThatAmount() {
		TrackingService service = new TrackingService();
		service.addProtein(10);
		assertEquals(10, service.getTotal());
		// for more matchers on advance asserts see: https://github.com/junit-team/junit4/wiki/Matchers-and-assertthat
		assertThat(service.getTotal(), is(10));	// this is the same as line above
		assertThat(service.getTotal(), allOf(is(10), instanceOf(Integer.class)));
	}

	@Test
	@Category(GoodTestsCategory.class)	// this is just to mark that this test belongs to this category 
	public void WhenRemovingProteinTotalRemainsZero() {
		TrackingService service = new TrackingService();
		service.removeProtein(5);
		assertEquals(0, service.getTotal());
	}
	
	/*@Test(expected = InvalidGoalException.class)	// you expect an exception to be thrown in response to passing -5
	public void WhenGoalIsSetToLessThanZeroExceptionIsThrown() throws InvalidGoalException {
		service.setGoal(-5);
	}*/
	
	// if basic exception testing (like the one above) is not enough,
	// you can create public field and annotate it with @Rule
	// and then test it for particular exception message for example like it is shown in WhenGoalIsSetToLessThanZeroExceptionIsThrown() below
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void WhenGoalIsSetToLessThanZeroExceptionIsThrown() throws InvalidGoalException {
		thrown.expect(InvalidGoalException.class);
		thrown.expectMessage("Goal was less than zero!"); // this message is set in TrackingService.setGoal()
		thrown.expectMessage(containsString("Goal"));
		service.setGoal(-5);
	}

	
	// this will apply to all test methods in this class
	// any method that does not finish in 20 ms will fail
	// for more rules see: https://github.com/junit-team/junit4/wiki/Rules
	// also check ErrorCollector, RuleChain and @ClassRule
	@Rule
	public Timeout timeout = new Timeout(20);
	
	@Test(timeout = 200)	// this test will fail if it does not finish in 200 ms
	public void BadTest() {
		for (int i = 0; i < 10000000; i++)
			service.addProtein(1);
	}
}
