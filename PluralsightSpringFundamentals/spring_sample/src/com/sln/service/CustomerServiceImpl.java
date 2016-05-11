package com.sln.service;

import java.util.List;

import com.sln.model.Customer;
import com.sln.repository.CustomerRepository;

import com.sln.repository.HibernateCustomerRepositoryImpl;

public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository customerRepository = new HibernateCustomerRepositoryImpl();
	
	/* (non-Javadoc)
	 * @see com.sln.service.CustomerService#findAll()
	 */
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}
}
