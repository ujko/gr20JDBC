package dao;

import dao.model.Address;
import dao.model.Person;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
//        long start = System.currentTimeMillis();
//        PersonDao dao = new PersonDaoMemImpl();
//        System.out.println(dao.getPersonsBetweenAge(12,35));
//        System.out.println(dao.getPersonsByLastName("Nowak"));
//        System.out.println(dao.getPersonsByLastName("Anna"));
//        System.out.println(dao.getPersonsByLastName("Jan"));

//        try {
//            System.out.println(dao.getPersonById(6));
//        } catch (NoPersonIdException e) {
//            System.out.println("Brak w bazie danych");
//        }
//        List<Person> personList = dao.getPersonsBetweenAge(12,12);
//        personList.forEach(System.out::println);
//        Person p = new Person();
//        p.setFirstName("Pawel");
//        p.setLastName("Dymsza");
//        dao.updatePerson(1, p);
//        dao.createTable();
//        dao.addPerson(new Person("Jan", "Nowak", 6));
//        dao.addPerson(new Person("Anna", "Dymna", 66));
//        dao.addPerson(new Person("Andrzej", "Nowak", 23));
//        List<Person> personList = dao.getPersonsByLastName("dymna");
//        personList.forEach(System.out::println);
//        long stop = System.currentTimeMillis();
//        System.out.println("Program wykonał się w " + (stop - start) + " ms");
//        dao.deletePerson(3);

        PersonDao dao = new PersonDaoJdbcImpl();
//        System.out.println(dao.getAllPersons().get(0));
//        System.out.println(dao.getPersonsByFirstName("Jan"));
        Person p = new Person("Agata", "Kowalska", 34);
        Address address1 = new Address();
        address1.setAddressId(4);
        address1.setCity("Poznan");
        address1.setStreet("Gajowa");
        address1.setPostCode("33333");
        p.addAddress(address1);
        Address address2 = new Address();
        address2.setAddressId(5);
        address2.setCity("Wroclaw");
        address2.setStreet("Poznanska");
        address2.setPostCode("60-333");
        p.addAddress(address2);
        dao.addPerson(p);
    }
}
