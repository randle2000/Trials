package com.sln.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sln.model.Customer;
import com.sln.repository.CustomerRepository;

public class CustomerServiceImpl implements CustomerService {
	//@Autowired
	private CustomerRepository customerRepository;
	
	public CustomerServiceImpl() {
		
	}
	
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		System.out.println("We are using Constructor Injection");
		this.customerRepository = customerRepository;
	}

	@Autowired
	public void setCustomerRepository(CustomerRepository customerRepository) {
		System.out.println("We are using Setter Injection");
		this.customerRepository = customerRepository;
	}

	public List<Customer> findAll() {
		return customerRepository.findAll();
	}
}
