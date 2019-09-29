package com.sda.customer.controller;

import com.sda.customer.dao.CustomerDao;
import com.sda.customer.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerDao dao;

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        System.out.println("Controller: getAllCustomers()");
        return dao.getAllCustomers();
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable int id) {
        System.out.println("Controller: getCustomerById " + id);
        return dao.getCustomerById(id);
    }

    @GetMapping("/customer")
    public List<Customer> getCustomersByName(@RequestParam String name) {
        System.out.println("Controller: getCustomersByName() " + name);
        return dao.getCustomersByName(name);
    }

    @GetMapping("/testCustomer")
    public String testCustomer(@RequestParam String name, @RequestParam int age) {
        return "Witaj " + name + " masz lat " + age;
    }

    @DeleteMapping("/deleteCustomer/{id}")
    public Customer deletCustomer(@PathVariable int id) {
        System.out.println("kasuje " + id);
        return dao.deleteCustomer(id);
    }

    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer) {
        System.out.println("dodaje " + customer);
        return dao.addCustomer(customer);
    }

    @PutMapping("/customers/{id}")
    public Customer modifyCustomer(@PathVariable int id, @RequestBody Customer customer) {
        System.out.println("modyfikuje " + customer);
        return dao.modifyCustomer(id, customer);
    }

    @RequestMapping(value = "/customers", method = RequestMethod.OPTIONS)
    public String options() {
        return "Jakies opcje programu";
    }
}
