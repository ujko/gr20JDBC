package dao;

import dao.model.Person;

import java.sql.SQLException;
import java.util.List;

public interface PersonDao {
    List<Person> getAllPersons();
    List<Person> getPersonsByFirstName(String firstName) throws SQLException;
    List<Person> getPersonsByLastName(String lastName) throws SQLException;
    Person getPersonById(int personId);
    List<Person> getPersonsBetweenAge(int minAge, int maxAge);
    void addPerson(Person person) throws SQLException;
    void deletePerson(int personId);
    void updatePerson(int personId, Person person);
}
