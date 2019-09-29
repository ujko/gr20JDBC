package com.sda.customer.dao;

import com.sda.customer.model.Customer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class CustomerDaoImpl implements CustomerDao {
    private Map<Integer, Customer> map;

    public CustomerDaoImpl() {
        map = new HashMap<>();
        addCustomer(new Customer("Ada", "11223344"));
        addCustomer(new Customer("Andrzej", "54678115"));
        addCustomer(new Customer("Ada", "445588789"));
        addCustomer(new Customer("Jerzy", "12345988"));
        addCustomer(new Customer("Kasia", "54689465"));
    }

    @Override
    public List<Customer> getAllCustomers() {
        System.out.println("DAO: getAllCustomers()");
        return new ArrayList<>(map.values());
    }

    @Override
    public Customer getCustomerById(int id) {
        System.out.println("DAO: getCustomerById() " + id);
        return map.get(id);
    }

    @Override
    public List<Customer> getCustomersByName(String name) {
        System.out.println("DAO: getCustomersByName() " + name);
        return getAllCustomers()
                .stream()
                .filter((x) -> x.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Customer> getCustomersByNumber(String customerNumber) {
        System.out.println("DAO: getCustomersByNumber() " + customerNumber);
        return getAllCustomers()
                .stream()
                .filter((x) -> x.getCustomerNumber().contains(customerNumber))
                .collect(Collectors.toList());
    }

    @Override
    public Customer deleteCustomer(int id) {
        System.out.println("DAO: deleteCustomer() " + id);
        return map.remove(id);
    }

    @Override
    public Customer addCustomer(Customer customer) {
        customer.setId(generateId());
        System.out.println("DAO: addCustomer() " + customer);
        return map.put(customer.getId(), customer);
    }

    private int generateId() {
        return map
                .keySet()
                .stream()
                .mapToInt(x -> x)
                .max()
                .orElse(0) + 1;
    }

    @Override
    public Customer modifyCustomer(int id, Customer newCustomer) {
        newCustomer.setId(id);
        System.out.println("DAO: modifyCustomer() " + newCustomer);
        return map.put(id, newCustomer);
    }
}
