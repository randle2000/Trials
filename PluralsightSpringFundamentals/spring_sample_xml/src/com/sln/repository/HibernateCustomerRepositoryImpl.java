package com.sln.repository;

import java.util.ArrayList;
import java.util.List;

import com.sln.model.Customer;

public class HibernateCustomerRepositoryImpl implements CustomerRepository {
	/* (non-Javadoc)
	 * @see com.sln.repository.CustomerRepository#findAll()
	 */
	public List<Customer> findAll() {
		List<Customer> customers = new ArrayList<>();
		
		Customer customer = new Customer();
		customer.setFirstName("Bryan");
		customer.setLastName("Adams");
		customers.add(customer);
		return customers;
	}
}
