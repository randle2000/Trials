import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.sln.service.CustomerService;
import com.sln.service.CustomerServiceImpl;


@Configuration
@ComponentScan({"com.sln"})
@PropertySource("app.properties")	// com/sln/model/app.properties
public class AppConfig {
	
	// this is for app.propetries
	@Bean
	public static PropertySourcesPlaceholderConfigurer getPropertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	// you can name beans whatever you want but it's convenient to call 'em
	// the same names as you would use for java instance variable
	@Bean(name = "customerService")	
	//@Scope("singleton")	// Spring will produce single instance of this bean per container
	@Scope("prototype")		// Spring will produce new instance of this bean per each request
	public CustomerService getCustomerService() {
		//CustomerServiceImpl customerService = new CustomerServiceImpl();
		//customerService.setCustomerRepository(getCustomerRepository());
		
		//CustomerServiceImpl customerService = new CustomerServiceImpl(getCustomerRepository());
		
		CustomerServiceImpl customerService = new CustomerServiceImpl();
		return customerService;
	}
	
//	@Bean(name = "customerRepository")
//	public CustomerRepository getCustomerRepository() {
//		return new HibernateCustomerRepositoryImpl();
//	}

}
