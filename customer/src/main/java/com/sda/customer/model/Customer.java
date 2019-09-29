package com.sda.customer.model;

public class Customer {
    private int id;
    private String name;
    private String customerNumber;

    public Customer() {
    }

    public Customer(String name, String customerNumber) {
        this.name = name;
        this.customerNumber = customerNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", customerNumber='" + customerNumber + '\'' +
                '}';
    }
}
