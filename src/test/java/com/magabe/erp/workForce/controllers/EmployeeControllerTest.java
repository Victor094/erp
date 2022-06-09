package com.magabe.erp.workForce.controllers;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.magabe.erp.workForce.services.EmployeeService;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {EmployeeController.class})
@ExtendWith(SpringExtension.class)
class EmployeeControllerTest {
    @Autowired
    private EmployeeController employeeController;

    @MockBean
    private EmployeeService employeeService;

    /**
     * Method under test: {@link EmployeeController#addEmployee(org.springframework.ui.Model)}
     */
    @Test
    void testAddEmployee() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/work-force/employeeAdd");
        MockMvcBuilders.standaloneSetup(this.employeeController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("employee"))
                .andExpect(MockMvcResultMatchers.view().name("/workForce/employeeAdd"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("/workForce/employeeAdd"));
    }

    /**
     * Method under test: {@link EmployeeController#addEmployee(org.springframework.ui.Model)}
     */
    @Test
    void testAddEmployee2() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/work-force/employeeAdd", "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.employeeController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("employee"))
                .andExpect(MockMvcResultMatchers.view().name("/workForce/employeeAdd"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("/workForce/employeeAdd"));
    }

    /**
     * Method under test: {@link EmployeeController#addNew(com.magabe.erp.workForce.entities.Employee)}
     */
    @Test
    void testAddNew() throws Exception {
        doNothing().when(this.employeeService).saveEmployee((com.magabe.erp.workForce.entities.Employee) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/work-force/register-employee");
        MockMvcBuilders.standaloneSetup(this.employeeController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("employee"))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/work-force/register-employee"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/work-force/register-employee"));
    }

    /**
     * Method under test: {@link EmployeeController#addNew(com.magabe.erp.workForce.entities.Employee)}
     */
    @Test
    void testAddNew2() throws Exception {
        doNothing().when(this.employeeService).saveEmployee((com.magabe.erp.workForce.entities.Employee) any());
        MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/work-force/register-employee");
        postResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.employeeController)
                .build()
                .perform(postResult)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("employee"))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/work-force/register-employee"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/work-force/register-employee"));
    }

    /**
     * Method under test: {@link EmployeeController#findAll(org.springframework.ui.Model)}
     */
    @Test
    void testFindAll() throws Exception {
        when(this.employeeService.findAllEmployees()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/work-force/register-employee");
        MockMvcBuilders.standaloneSetup(this.employeeController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("employee"))
                .andExpect(MockMvcResultMatchers.view().name("/workForce/employees"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("/workForce/employees"));
    }

    /**
     * Method under test: {@link EmployeeController#findAll(org.springframework.ui.Model)}
     */
    @Test
    void testFindAll2() throws Exception {
        when(this.employeeService.findAllEmployees()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/work-force/register-employee");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.employeeController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("employee"))
                .andExpect(MockMvcResultMatchers.view().name("/workForce/employees"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("/workForce/employees"));
    }
}

