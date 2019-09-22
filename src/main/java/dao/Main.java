package dao;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        long start = System.currentTimeMillis();
        PersonDao dao = new PersonDaoMemImpl();
        System.out.println(dao.getPersonsBetweenAge(12,35));
        System.out.println(dao.getPersonsByLastName("Nowak"));
        System.out.println(dao.getPersonsByLastName("Anna"));
        System.out.println(dao.getPersonsByLastName("Jan"));

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
        long stop = System.currentTimeMillis();
        System.out.println("Program wykonał się w " + (stop - start) + " ms");
//        dao.deletePerson(3);


    }
}
