package dao;

import dao.model.Address;
import dao.model.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDaoJdbcImpl implements PersonDao {
    private final String DB_CONNECT =
            "jdbc:mysql://localhost:3306/mysql?useTimezone=true&serverTimezone=UTC";
    private Connection connection;
    private Statement statement;

    public void createTable() throws SQLException {
        createConnection();
        String query = "create table person(id int not null, " +
                "first_name varchar(55) not null, " +
                "last_name varchar(65) not null," +
                "age int)";
        statement.executeUpdate(query);
        closeConnection();
    }

    private void createConnection() {
        try {
            System.out.println("tworzę połączenie do bazy danych");
            connection = DriverManager.getConnection(DB_CONNECT, "root", "example");
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.err.println("Błąd połączenia z bazą danych");
            System.exit(1);
        }
    }

    private void closeConnection() {
    try {
        System.out.println("zamykam połączenie do bazy danych");
        statement.close();
        connection.close();
        } catch (SQLException e) {
            System.err.println("Błąd podczas odłączania bazy danych");
        }
    }

    @Override
    public List<Person> getAllPersons() throws SQLException {
        String query = "select * from person";
        createConnection();
        List<Person> persons = getPersonsFromResultSet(statement.executeQuery(query));
        for (Person p: persons) {
            String addressQuery = "select * from address where person_id = " + p.getPersonId();
            ResultSet resultSet = statement.executeQuery(addressQuery);
            while (resultSet.next()) {
                Address a = new Address();
                a.setAddressId(resultSet.getInt("id"));
                a.setCity(resultSet.getString("city"));
                a.setStreet(resultSet.getString("street"));
                a.setPostCode(resultSet.getString("post_code"));
                p.addAddress(a);
            }
        }
        closeConnection();
        return persons;
    }

    @Override
    public List<Person> getPersonsByFirstName(String firstName) throws SQLException {
        try {
            connection = DriverManager.getConnection(DB_CONNECT, "root", "example");
        } catch (SQLException e) {
            System.exit(1);
        }
        String query = "select * from person where first_name = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, firstName);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Person> personList = getPersonsFromResultSet(resultSet);
        resultSet.close();
        preparedStatement.close();
        connection.close();
        return personList;
    }

    private List<Person> getPersonsFromResultSet(ResultSet resultSet) throws SQLException {
        List<Person> result = new ArrayList<>();
        while (resultSet.next()) {
            Person person = new Person();
            person.setPersonId(resultSet.getInt("id"));
            person.setFirstName(resultSet.getString("first_name"));
            person.setLastName(resultSet.getString("last_name"));
            person.setAge(resultSet.getInt("age"));
            result.add(person);
        }
        return result;
    }

    @Override
    public List<Person> getPersonsByLastName(String lastName) throws SQLException {
        createConnection();
        String query = "select * from person where last_name='" + lastName +"'";
        System.out.println(query);
        ResultSet resultSet = statement.executeQuery(query);
        List<Person> personsFromResultSet = getPersonsFromResultSet(resultSet);
        closeConnection();
        return personsFromResultSet;
    }

    @Override
    public Person getPersonById(int personId) throws SQLException {
        String query = "select * from person where id = " + personId;
        createConnection();
        List<Person> personList = getPersonsFromResultSet(statement.executeQuery(query));
        closeConnection();
        if(personList.isEmpty()){
            throw new NoPersonIdException("brak id w bazie danych");
        }
        return personList.get(0);
    }

    @Override
    public List<Person> getPersonsBetweenAge(int minAge, int maxAge) throws SQLException {
        if(minAge > maxAge) {
            minAge += maxAge;
            maxAge = minAge - maxAge;
            minAge -= maxAge;
        }
        String query = String.format("select * from person where age between %d and %d", minAge, maxAge);
        createConnection();
        List<Person> personList = getPersonsFromResultSet(statement.executeQuery(query));
        closeConnection();
        return personList;
    }

    @Override
    public void addPerson(Person person) throws SQLException {
        person.setPersonId(generateId());
        String query = String.format("insert into person(id, first_name, last_name, age) values(%d, '%s', '%s', %d)"
                ,person.getPersonId(), person.getFirstName(), person.getLastName(), person.getAge());
        createConnection();
        statement.executeUpdate(query);
        closeConnection();
    }

    private int generateId() {
        String query = "select max(id) from person";
        createConnection();
        int result = 0;
        try (ResultSet resultSet = statement.executeQuery(query)){
            if(resultSet.next()) {
                result = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
        return result + 1;
    }

    @Override
    public void deletePerson(int personId) throws SQLException {
        createConnection();
        String query = "delete from person where id = " + personId;
        int changedRows = statement.executeUpdate(query);
        System.out.println("Skasowano " + changedRows + " record(ów)");
        closeConnection();
    }

    @Override
    public void updatePerson(int personId, Person person) throws SQLException {
        if(person == null) {
            return;
        }
        StringBuilder query = new StringBuilder();
        query.append("update person set ");
        String firstName = person.getFirstName();
        String temp = "";
        if(firstName != null && !firstName.isEmpty()) {
            temp += " first_name = '" + firstName +"',";
        }
        String lastName = person.getLastName();
        if(lastName != null && !lastName.isEmpty()) {
            temp +=" last_name = '" + lastName +"',";
        }
        int age = person.getAge();
        if(age > 0) {
            temp += " age = " + age;
        }
        if(temp.endsWith(",")) {
            temp = temp.substring(0,temp.length()-1);
        }
        query.append(temp);
        query.append(" where id = " + personId);
        createConnection();
        System.out.println(query.toString());
        statement.executeUpdate(query.toString());
        closeConnection();
    }
}
