package com.example.employee.service.impl;

import com.example.employee.entity.Employee;
import com.example.employee.repos.EmployeeRepo;
import com.example.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public void validateEmployee(Employee employee) {
      Employee employe1  = employeeRepo.save(employee);
    }

    public List<String> employeeList(List<String> list){

        Set<String> withoutDup = new HashSet<>();
        for (String str :list) {
            withoutDup.add(str);
        }
        return withoutDup.stream().collect(Collectors.toList());
    }

    @Override
    public Employee persistValidatedEmployee(Employee employee) {
       return employeeRepo.save(employee);
    }

    @Override
    public List<Employee> getEmployeesList() {
      return employeeRepo.findAllByOrderByFirstName();
    }
}
