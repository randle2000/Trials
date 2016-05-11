package com.sln.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.sln.model.Customer;

@Repository
public class HibernateCustomerRepositoryImpl implements CustomerRepository {
	
	@Value("${someProperty}")
	private String someValue;
	
	public List<Customer> findAll() {
		List<Customer> customers = new ArrayList<>();
		
		Customer customer = new Customer();
		//customer.setFirstName("Bryan");
		customer.setFirstName(someValue);
		customer.setLastName("Adams");
		customers.add(customer);
		return customers;
	}
}
