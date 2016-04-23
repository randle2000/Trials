import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.ExcludeCategory;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/*
 * Categories are used to group some of test method in to categories
 * You create an empty interface as a category and then mark necessary test methods with it
 * You can create whole hierarchy of categories using inheritance   
 */
@RunWith(Categories.class)					// this will run all tests that are marked  
@IncludeCategory(GoodTestsCategory.class)	// with GoodTestsCategory in all classes listed below
@ExcludeCategory(BadCategory.class)			// it seems that ExcludeCategory has preference over IncludeCategory if some method belongs to both
@Suite.SuiteClasses({						// You can mark methods or a whole class (see HelloJUnitTest) with a category 
	HelloJUnitTest.class, 
	TrackingServiceTests.class
})
public class GoodTestsSuite {

}
