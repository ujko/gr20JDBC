package com.sda.clientCustomer.model;

public class Person {
    private int id;
    private String name;
    private String customerNumber;

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
        return "{" +
                "\"id\":" + id +
                ",\"name\":\"" + name + '\"' +
                ", \"customerNumber\":\"" + customerNumber + '\"' +
                '}';
    }
}
