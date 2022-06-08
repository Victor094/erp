package com.magabe.erp.payroll.controllers;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.magabe.erp.payroll.entities.Payroll;
import com.magabe.erp.payroll.services.PayrollService;

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

@ContextConfiguration(classes = {PayrollController.class})
@ExtendWith(SpringExtension.class)
class PayrollControllerTest {
    @Autowired
    private PayrollController payrollController;

    @MockBean
    private PayrollService payrollService;

    /**
     * Method under test: {@link PayrollController#addEmployeeToPayroll(org.springframework.ui.Model)}
     */
    @Test
    void testAddEmployeeToPayroll() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/payroll/payroll_add");
        MockMvcBuilders.standaloneSetup(this.payrollController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("payroll"))
                .andExpect(MockMvcResultMatchers.view().name("/payroll/payrollAdd"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("/payroll/payrollAdd"));
    }

    /**
     * Method under test: {@link PayrollController#addEmployeeToPayroll(org.springframework.ui.Model)}
     */
    @Test
    void testAddEmployeeToPayroll2() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/payroll/payroll_add");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.payrollController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("payroll"))
                .andExpect(MockMvcResultMatchers.view().name("/payroll/payrollAdd"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("/payroll/payrollAdd"));
    }

    /**
     * Method under test: {@link PayrollController#addNew(com.magabe.erp.payroll.entities.Payroll)}
     */
    @Test
    void testAddNew() throws Exception {
        doNothing().when(this.payrollService).SavePayroll((com.magabe.erp.payroll.entities.Payroll) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/payroll/register_payroll");
        MockMvcBuilders.standaloneSetup(this.payrollController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("payroll"))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/payroll/register_payroll"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/payroll/register_payroll"));
    }

    /**
     * Method under test: {@link PayrollController#addNew(com.magabe.erp.payroll.entities.Payroll)}
     */
    @Test
    void testAddNew2() throws Exception {
        doNothing().when(this.payrollService).SavePayroll((com.magabe.erp.payroll.entities.Payroll) any());
        MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/payroll/register_payroll");
        postResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.payrollController)
                .build()
                .perform(postResult)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("payroll"))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/payroll/register_payroll"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/payroll/register_payroll"));
    }

    /**
     * Method under test: {@link PayrollController#PayrollRegisterForm(org.springframework.ui.Model)}
     */
    @Test
    void testPayrollRegisterForm() throws Exception {
        when(this.payrollService.findAllPayroll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/payroll/register_payroll");
        MockMvcBuilders.standaloneSetup(this.payrollController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("payroll"))
                .andExpect(MockMvcResultMatchers.view().name("payroll/payrollE"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("payroll/payrollE"));
    }

    /**
     * Method under test: {@link PayrollController#PayrollRegisterForm(org.springframework.ui.Model)}
     */
    @Test
    void testPayrollRegisterForm2() throws Exception {
        when(this.payrollService.findAllPayroll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/payroll/register_payroll");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.payrollController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("payroll"))
                .andExpect(MockMvcResultMatchers.view().name("payroll/payrollE"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("payroll/payrollE"));
    }

    /**
     * Method under test: {@link PayrollController#showRemuneration(long, org.springframework.ui.Model)}
     */
    @Test
    void testShowRemuneration() throws Exception {
        Payroll payroll = new Payroll();
        payroll.setEmail("jane.doe@example.org");
        payroll.setFirstName("Jane");
        payroll.setGender("Gender");
        payroll.setId(123L);
        payroll.setLastName("Doe");
        payroll.setMedicalAid(10.0d);
        payroll.setNormalRate(10.0d);
        payroll.setOverTimeRate(10.0d);
        payroll.setPosition("Position");
        payroll.setSalary(10.0d);
        payroll.setTax(10.0d);
        when(this.payrollService.getCandidateById(anyLong())).thenReturn(payroll);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/payroll/register_payroll/remuneration/{id}", 123L);
        MockMvcBuilders.standaloneSetup(this.payrollController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("payroll"))
                .andExpect(MockMvcResultMatchers.view().name("payroll/remuneration"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("payroll/remuneration"));
    }

    /**
     * Method under test: {@link PayrollController#showRemuneration(long, org.springframework.ui.Model)}
     */
    @Test
    void testShowRemuneration2() throws Exception {
        Payroll payroll = new Payroll();
        payroll.setEmail("jane.doe@example.org");
        payroll.setFirstName("Jane");
        payroll.setGender("Gender");
        payroll.setId(123L);
        payroll.setLastName("Doe");
        payroll.setMedicalAid(10.0d);
        payroll.setNormalRate(10.0d);
        payroll.setOverTimeRate(10.0d);
        payroll.setPosition("Position");
        payroll.setSalary(10.0d);
        payroll.setTax(10.0d);
        when(this.payrollService.getCandidateById(anyLong())).thenReturn(payroll);
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/payroll/register_payroll/remuneration/{id}",
                123L);
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.payrollController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("payroll"))
                .andExpect(MockMvcResultMatchers.view().name("payroll/remuneration"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("payroll/remuneration"));
    }
}

