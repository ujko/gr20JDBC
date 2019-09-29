package com.sda.customer.dao;

import com.sda.customer.model.Customer;

import java.util.List;

public interface CustomerDao {
    List<Customer> getAllCustomers();
    Customer getCustomerById(int id);
    List<Customer> getCustomersByName(String name);
    List<Customer> getCustomersByNumber(String customerNumber);
    Customer deleteCustomer(int id);
    Customer addCustomer(Customer customer);
    Customer modifyCustomer(int id, Customer newCustomer);
}
