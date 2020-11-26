package com.example.employee.service;

import com.example.employee.entity.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
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

    @Test
    public void removeDuplicate(){

        List<String> list = new ArrayList<>();
        list.add("karthik");
        list.add("kumar");
        list.add("Veda");
        list.add("kumar");
        List<String> emp = employeeService.employeeList(list);
        Assertions.assertTrue(emp.size() == 3);
        System.out.println("emp = " + emp);
    }

    @Test
    public void removeDuplicates(){
        List<String> list = new ArrayList<>();
        List<String> emp = employeeService.employeeList(null);
        Assertions.assertTrue(emp.size() == 3);
        System.out.println("emp = " + emp);
    }


    public Supplier<Employee> employeeSupplier = () ->{
        Employee employee = new Employee();
        employee.setFirstName("General");
        employee.setLastName("Society");
        employee.setGender("male");
        employee.setDepartment("company");
        employee.setDob(new Date());
        employee.setEmail("gs@gmail.com");
        return employee;
    };
}
