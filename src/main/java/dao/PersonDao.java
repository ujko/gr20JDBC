package dao;

import dao.model.Person;

import java.sql.SQLException;
import java.util.List;

public interface PersonDao {
    List<Person> getAllPersons() throws SQLException;
    List<Person> getPersonsByFirstName(String firstName) throws SQLException;
    List<Person> getPersonsByLastName(String lastName) throws SQLException;
    Person getPersonById(int personId) throws SQLException;
    List<Person> getPersonsBetweenAge(int minAge, int maxAge) throws SQLException;
    void addPerson(Person person) throws SQLException;
    void deletePerson(int personId) throws SQLException;
    void updatePerson(int personId, Person person) throws SQLException;
}
