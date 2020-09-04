package com.tracker.coronaviruslivetracker.services;

import java.util.List;
import com.tracker.coronaviruslivetracker.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustome(int theId);

	public List<Customer> searchCustomers(String theSearchName);
}
