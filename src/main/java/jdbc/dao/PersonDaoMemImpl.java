package jdbc.dao;

import jdbc.dao.model.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PersonDaoMemImpl implements PersonDao {
    private final String DB_CONNECT =
            "jdbc:mysql://localhost:3306/mysql?useTimezone=true&serverTimezone=UTC";
    private Connection connection;
    private Statement statement;
    private Map<Integer, Person> personMap;

    public PersonDaoMemImpl() throws SQLException {
        initialize();
    }

    private void initialize() throws SQLException {
        personMap = new HashMap<>();
        String query = "select * from person";
        createConnection();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            personMap.put(id,
                    new Person()
                            .setPersonId(id)
                            .setFirstName(resultSet.getString("first_name"))
                            .setLastName(resultSet.getString("last_name"))
                            .setAge(resultSet.getInt("age"))
                    );
        }
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
        return new ArrayList<>(personMap.values());
    }

    @Override
    public List<Person> getPersonsByFirstName(String firstName) throws SQLException {
        return getAllPersons()
                .stream()
                .filter(x->x.getFirstName().equalsIgnoreCase(firstName))
                .collect(Collectors.toList());
    }

    @Override
    public List<Person> getPersonsByLastName(String lastName) throws SQLException {
        return getAllPersons()
                .stream()
                .filter(x->x.getLastName().equalsIgnoreCase(lastName))
                .collect(Collectors.toList());
    }

    @Override
    public Person getPersonById(int personId) throws SQLException {
        return personMap.get(personId);
    }

    @Override
    public List<Person> getPersonsBetweenAge(int minAge, int maxAge) throws SQLException {
        return getAllPersons()
                .stream()
                .filter(x -> x.getAge() >= minAge)
                .filter(x -> x.getAge() <= maxAge)
                .collect(Collectors.toList());
    }

    @Override
    public void addPerson(Person person) throws SQLException {
        person.setPersonId(generateId());
        String query = String.format("insert into person values(%d, '%s', '%s', %d)"
        , person.getPersonId(), person.getFirstName(), person.getLastName(), person.getAge());
        createConnection();
        statement.executeUpdate(query);
        closeConnection();
        initialize();
    }

    private int generateId() {
        return personMap
                .keySet()
                .stream()
                .mapToInt(x -> x)
                .max()
                .orElse(0) + 1;
    }

    @Override
    public void deletePerson(int personId) throws SQLException {
        String query = "delete from person where id = " + personId;
        createConnection();
        statement.executeUpdate(query);
        closeConnection();
        initialize();
    }

    @Override
    public void updatePerson(int personId, Person person) throws SQLException {
        new PersonDaoJdbcImpl().updatePerson(personId, person);
        initialize();
    }
}
