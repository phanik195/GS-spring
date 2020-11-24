package com.example.employee.controller;

import com.example.employee.entity.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;
import java.time.Duration;
import java.time.Instant;
import java.util.function.Supplier;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class EmployeeControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(wac).build();
    }

    /**
     * Creating valid employee through API by using {@link MockMvc}.
     * @throws Exception
     */
    @Test
    public void createValidEmployeeSaveMock() throws Exception {
        ServletContext servletContext = wac.getServletContext();
        Assert.assertNotNull(servletContext);
        Assert.assertTrue(servletContext instanceof MockServletContext);

        Instant startTime = Instant.now();

        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(employeeSupplier.get());

        ResultActions resultActions =
                mockMvc
                        .perform(post("/company/create/employee")
                                .contextPath("/company")
                                .header("Content-Type", "application/json")
                                .accept(MediaType.APPLICATION_JSON_VALUE)
                                .content(content))
                        .andDo(MockMvcResultHandlers.print())
                        .andExpect(MockMvcResultMatchers.status().isOk());

        Instant endTime = Instant.now();
        System.out.println("Time taken = "+ Duration.between(startTime,endTime).toMillis());

    }


    /**
     * Getting List Employee object using API.
     * @throws Exception
     */
    @Test
    public void getEmployeeListMock() throws Exception {
        ServletContext servletContext = wac.getServletContext();
        Assert.assertNotNull(servletContext);
        Assert.assertTrue(servletContext instanceof MockServletContext);

        Instant startTime = Instant.now();

        ObjectMapper mapper = new ObjectMapper();

        ResultActions resultActions =
                mockMvc.perform(get("/company/employee/list")
                                .contextPath("/company")
                                .header("Content-Type", "application/json")
                                .accept(MediaType.APPLICATION_JSON_VALUE))
                        .andDo(MockMvcResultHandlers.print())
                        .andExpect(MockMvcResultMatchers.status().isOk());

        Instant endTime = Instant.now();
        System.out.println("Time taken = "+ Duration.between(startTime,endTime).toMillis());

    }

    public Supplier<Employee> employeeSupplier = () ->{
        Employee employee = new Employee();
        employee.setFirstName("General");
        employee.setLastName("Society");
        employee.setGender("male");
        employee.setDepartment("company");
        return employee;
    };
}
