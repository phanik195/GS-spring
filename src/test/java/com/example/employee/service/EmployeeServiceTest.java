package com.example.employee.service;

import com.example.employee.entity.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class EmployeeServiceTest {
    
    @Autowired
    private EmployeeService employeeService;


    @Test
    public void persistEmployee(){
        Employee employee =  employeeService.persistValidatedEmployee(employeeSupplier.get());
        Assertions.assertEquals(employee.getDepartment() , employeeSupplier.get().getDepartment());
    }


    @Test
    public void getEmployeeList(){
        List<Employee>  employeesList = employeeService.getEmployeesList();
        assertTrue(employeesList.size() > 0);
    }



    public Supplier<Employee> employeeSupplier = () ->{
        Employee employee = new Employee();
        employee.setFirstName("General");
        employee.setLastName("Society");
        employee.setGender("male");
        employee.setDepartment("company");
        employee.setDob(new Date());
        return employee;
    };
}
