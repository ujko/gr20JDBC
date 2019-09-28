package jpa;

import jpa.model.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        addEmployees();
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager em = factory.createEntityManager();

        

        em.close();
    }

    private static void addEmployees() {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager em = factory.createEntityManager();
        Employee e = new Employee();
        e.setName("Pawel");
        e.setSalary(12345.22);
        Employee e1 = new Employee();
        e1.setName("Darek");
        e1.setSalary(2345.34);
        Employee e2 = new Employee();
        e2.setName("Ania");
        e2.setSalary(245.22);
        Employee e3 = new Employee();
        e3.setName("Ilona");
        e3.setSalary(42345.34);
        Employee e4 = new Employee();
        e4.setName("Krzysztof");
        e4.setSalary(500.34);
        em.getTransaction().begin();
        em.persist(e);
        em.persist(e1);
        em.persist(e2);
        em.persist(e3);
        em.persist(e4);
        em.getTransaction().commit();
        em.close();
    }
}
