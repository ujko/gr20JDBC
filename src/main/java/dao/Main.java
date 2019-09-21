package dao;

import dao.model.Person;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        long start = System.currentTimeMillis();
        PersonDaoJdbcImpl dao = new PersonDaoJdbcImpl();
//        dao.createTable();
//        dao.addPerson(new Person("Jan", "Nowak", 6));
        List<Person> personList = dao.getPersonsByLastName("dymna");
        personList.forEach(System.out::println);
        long stop = System.currentTimeMillis();
        System.out.println("Program wykonał się w " + (stop - start) + " ms");
    }
}
