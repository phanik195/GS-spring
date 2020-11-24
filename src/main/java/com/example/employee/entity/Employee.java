package com.example.employee.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Employee implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    private String firstName;

    private String lastName;

    private String gender;

    private String department;

    @Temporal(TemporalType.DATE)
    private Date dob;

    public Date getDob() {
        return dob;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" + "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", gender='" + gender + '\'' + ", department='" + department + '\'' + ", dob=" + dob + '}';
    }
}
