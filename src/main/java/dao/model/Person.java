package dao.model;

public class Person {
    private int personId;
    private String firstName;
    private String lastName;
    private int age;

    public Person(){}
    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public int getPersonId() {
        return personId;
    }

    public Person setPersonId(int personId) {
        this.personId = personId;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Person setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Person setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Person setAge(int age) {
        this.age = age;
        return this;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
