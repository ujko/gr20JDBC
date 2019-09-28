package jpa.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employees")
@NamedQueries({
        @NamedQuery(name = Employee.BY_NAME, query = "select e from Employee e where e.name = :name"),
        @NamedQuery(name = Employee.BY_SALARY, query = "select e from Employee e where e.salary between ?1 and ?2")
})
//@SecondaryTable(name = "phones")
public class Employee {
    public static final String BY_NAME = "imie";
    public static final String BY_SALARY = "salary";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private int employeeId;
    @Column(name = "employee_name")
    private String name;
    @Column(name = "employee_salary")
    private double salary;

//    @Column(name = "employee_phone", table = "phones")
//    private String phone;

//    @Embedded
//    @OneToOne
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "telefon")
    private List<Phone> phone;

    public List<Phone> getPhone() {
        return phone;
    }

    public void setPhone(List<Phone> phone) {
        this.phone = phone;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void addPhone(Phone phone) {
        this.phone.add(phone);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
