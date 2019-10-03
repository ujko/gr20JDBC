package com.sda.clientCustomer.controller;

import com.sda.clientCustomer.model.Person;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
public class CustomController {

    @GetMapping("/getAll")
    public void getAllCustomers() {
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> forEntity = template.getForEntity("http://localhost:8080/customers", String.class);
        System.out.println(forEntity.getStatusCodeValue());
        System.out.println(forEntity.getBody());
    }

    @GetMapping("/getpersons")
    public void getPersons() {
        RestTemplate template = new RestTemplate();
        Person[] persons = template.getForObject("http://localhost:8080/customers", Person[].class);
        System.out.println(Arrays.toString(persons));
    }

    @GetMapping("/delete/{id}")
    public String deletePerson(@PathVariable int id) {
        RestTemplate template = new RestTemplate();
        template.delete("http://localhost:8080/deleteCustomer/" + id);
        return "Skasowano";
    }

    @GetMapping("/addPerson")
    public String addPerson() {
        RestTemplate template = new RestTemplate();
        Person p = new Person();
        p.setCustomerNumber("customer number");
        p.setName("Dawid");
        HttpEntity<Person> entity = new HttpEntity<>(p);
        ResponseEntity<Person> personResponseEntity =
                template.postForEntity("http://localhost:8080/customers", entity, Person.class);
        int statusCode = personResponseEntity.getStatusCodeValue();
        return "Dodano person (Status code: " + statusCode + ")";
    }

    @GetMapping("/modifyPerson")
    public String modifyPerson() {
        RestTemplate template = new RestTemplate();
        Person p = new Person();
        p.setCustomerNumber("changed number");
        p.setName("changed name");
        HttpEntity<Person> entity = new HttpEntity<>(p);
        template.put("http://localhost:8080/customers/2", entity);
        return "Zmieniono pomyślnie ";
    }

    @GetMapping("/getperson")
    public Person getPerson(@RequestParam int id) {
        RestTemplate template = new RestTemplate();
        return template.getForObject("http://localhost:8080/customers/" + id, Person.class);
    }
}
