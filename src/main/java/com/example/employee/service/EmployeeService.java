package com.example.employee.service;

import com.example.employee.entity.Employee;

import java.util.List;

public interface EmployeeService {

     void validateEmployee(Employee employee);

     Employee persistValidatedEmployee(Employee employee);

     List<Employee> getEmployeesList();
}
