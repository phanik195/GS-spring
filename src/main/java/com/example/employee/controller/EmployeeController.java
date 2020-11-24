package com.example.employee.controller;

import com.example.employee.dto.EmployeeDto;
import com.example.employee.entity.Employee;
import com.example.employee.service.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.util.List;

@RestController
@CrossOrigin
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * Creating Employee's through API.
     *
     * @param
     * @return
     */
    @RequestMapping(method = RequestMethod.POST , value = "/create/employee")
    public @ResponseBody HttpEntity<?> createEmployee(
            @RequestBody EmployeeDto employeeDto, HttpServletRequest request) throws NoSuchFieldException, JsonProcessingException {

            try {
                employeeService.persistValidatedEmployee(employeeDto.getEmployee());

            }catch (Exception e){
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }

        return ResponseEntity.status(HttpStatus.OK).build();

    }


    /**
     * Get employee objects.
     * @return
     */
    @RequestMapping(method = RequestMethod.GET , value = "/employee/list")
    public @ResponseBody HttpEntity<?> getEmployeeList(){

        List<Employee> employeeList;
        try {

            employeeList = employeeService.getEmployeesList();

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
      return new ResponseEntity<>(employeeList,HttpStatus.OK);
    }
}
