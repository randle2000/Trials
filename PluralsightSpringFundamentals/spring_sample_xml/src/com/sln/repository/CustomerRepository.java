package com.sln.repository;

import java.util.List;

import com.sln.model.Customer;

public interface CustomerRepository {

	public abstract List<Customer> findAll();

}