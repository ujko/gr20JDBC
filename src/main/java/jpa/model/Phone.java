package jpa.model;

import javax.persistence.*;

//@Embeddable
@Entity
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int phone_id;
    private String type;
    private String number;

//    @OneToOne(mappedBy = "phone")
    @ManyToOne
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }
//
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getPhone_id() {
        return phone_id;
    }

    public void setPhone_id(int phone_id) {
        this.phone_id = phone_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "type='" + type + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
