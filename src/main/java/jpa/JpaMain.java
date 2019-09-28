package jpa;

import jpa.model.Employee;
import jpa.model.Phone;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
//        addEmployees();
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager em = factory.createEntityManager();
//        Phone phone = em.find(Phone.class, 1);
//        System.out.println(phone);
//        System.out.println(phone.getEmployee());
//        Employee e = em.find(Employee.class, 3);
//        System.out.println(e);
//        System.out.println("pobrałem employee");
//        List<Phone> phones = e.getPhone();
//        System.out.println("pobieram phones");
//        System.out.println(phones);

        Employee e = new Employee();
        e.setSalary(12.2);
        e.setName("Jurek");
        Phone phone = new Phone();
        phone.setNumber("7777774444");
        phone.setType("cell");
        Phone p1 = new Phone();
        p1.setNumber("111111111");
        p1.setType("home");
        List<Phone> phones = new ArrayList<>();
        phones.add(p1);
        phones.add(phone);
        e.setPhone(phones);

        //        e.setPhone(phone);
        em.getTransaction().begin();
//        em.persist(phone);
//        em.persist(p1);
        Employee employee = em.find(Employee.class, 1);
        Phone newPhone = new Phone();
        newPhone.setType("work");
        newPhone.setNumber("2323232323");
        employee.addPhone(newPhone);
//        Employee e = em.find(Employee.class, 1);
//        em.remove(e);

        em.getTransaction().commit();
//        Employee employee = em.find(Employee.class, 1);
//        System.out.println(employee);
//        Phone phone = employee.getPhone();
        em.close();

    }

    private void postMain() {
        //        em.getTransaction().begin();

//        Employee employee = em.find(Employee.class, 2);
//        employee.setSalary(3000.0);
//        System.out.println(employee);
//        em.getTransaction().commit();

//        TypedQuery<Employee> employees =
//                em.createQuery("select e from Employee e where e.name = :first_name", Employee.class);
//        employees.setParameter("first_name", "Ilona");
//        List<Employee> resultList = employees.getResultList();
//        resultList.forEach(System.out::println);

//        TypedQuery<Employee> namedQuery = em.createNamedQuery(Employee.BY_NAME, Employee.class);
//        namedQuery.setParameter("name", "Pawel");
//        namedQuery.getResultStream().forEach(System.out::println);

//        TypedQuery<Employee> namedQuery = em.createNamedQuery(Employee.BY_SALARY, Employee.class);
//        namedQuery.setParameter(1, 200.0);
//        namedQuery.setParameter(2, 600.0);
//        namedQuery.getResultStream().forEach(System.out::println);

//        Query query = em.createQuery("select e.name, e.salary from Employee e where e.salary > 1000.0");
//        List<Object[]> resultList = query.getResultList();
//        for (Object[] o : resultList) {
//            System.out.println(o[0] + " " + o[1]);
//        }

//        Query query = em.createQuery("select e.name, e.salary from Employee e where e.salary > 1000.0");
//        List resultList = query.getResultList();
//        for (Object o : resultList) {
//            Object[] a = (Object[]) o;
//            System.out.println(a[0] + " " + a[1]);
//        }

//        Query query = em.createQuery("select count(e) from Employee e where e.salary > 1000.0");
//        System.out.println(query.getSingleResult());
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
