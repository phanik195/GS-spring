package com.example.employee.repos;

import com.example.employee.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee,Long> {

     List<Employee> findAllByOrderByFirstName();
}
