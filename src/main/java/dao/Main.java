package dao;

import dao.model.Person;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
//        long start = System.currentTimeMillis();
        PersonDaoJdbcImpl dao = new PersonDaoJdbcImpl();
        Person p = new Person();
        p.setFirstName("Pawel");
//        p.setLastName("Dymsza");
        dao.updatePerson(1, p);
//        dao.createTable();
//        dao.addPerson(new Person("Jan", "Nowak", 6));
//        dao.addPerson(new Person("Anna", "Dymna", 66));
//        dao.addPerson(new Person("Andrzej", "Nowak", 23));
//        List<Person> personList = dao.getPersonsByLastName("dymna");
//        personList.forEach(System.out::println);
//        long stop = System.currentTimeMillis();
//        System.out.println("Program wykonał się w " + (stop - start) + " ms");
//        dao.deletePerson(3);


    }
}
