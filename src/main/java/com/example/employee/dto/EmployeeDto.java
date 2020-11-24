package com.example.employee.dto;

import com.example.employee.entity.Employee;

import java.io.Serializable;

public class EmployeeDto implements Serializable {

    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "EmployeeDto{" + "employee=" + employee + '}';
    }
}
