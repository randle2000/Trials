package com.sln.service;

import java.util.List;

import com.sln.model.Customer;
import com.sln.repository.CustomerRepository;

public interface CustomerService {

	List<Customer> findAll();

}