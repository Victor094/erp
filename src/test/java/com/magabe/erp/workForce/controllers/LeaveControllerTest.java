package com.magabe.erp.workForce.controllers;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.magabe.erp.workForce.entities.Leave;
import com.magabe.erp.workForce.services.LeaveService;

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

@ContextConfiguration(classes = {LeaveController.class})
@ExtendWith(SpringExtension.class)
class LeaveControllerTest {
    @Autowired
    private LeaveController leaveController;

    @MockBean
    private LeaveService leaveService;

    /**
     * Method under test: {@link LeaveController#addLeave(org.springframework.ui.Model)}
     */
    @Test
    void testAddLeave() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/work-force/leave-add");
        MockMvcBuilders.standaloneSetup(this.leaveController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("leave"))
                .andExpect(MockMvcResultMatchers.view().name("/workForce/leaveAdd"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("/workForce/leaveAdd"));
    }

    /**
     * Method under test: {@link LeaveController#addLeave(org.springframework.ui.Model)}
     */
    @Test
    void testAddLeave2() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/work-force/leave-add", "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.leaveController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("leave"))
                .andExpect(MockMvcResultMatchers.view().name("/workForce/leaveAdd"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("/workForce/leaveAdd"));
    }

    /**
     * Method under test: {@link LeaveController#addNew(com.magabe.erp.workForce.entities.Leave)}
     */
    @Test
    void testAddNew() throws Exception {
        doNothing().when(this.leaveService).saveLeave((com.magabe.erp.workForce.entities.Leave) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/work-force/apply-leave");
        MockMvcBuilders.standaloneSetup(this.leaveController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("leave"))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/work-force/apply-leave"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/work-force/apply-leave"));
    }

    /**
     * Method under test: {@link LeaveController#addNew(com.magabe.erp.workForce.entities.Leave)}
     */
    @Test
    void testAddNew2() throws Exception {
        doNothing().when(this.leaveService).saveLeave((com.magabe.erp.workForce.entities.Leave) any());
        MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/work-force/apply-leave");
        postResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.leaveController)
                .build()
                .perform(postResult)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("leave"))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/work-force/apply-leave"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/work-force/apply-leave"));
    }

    /**
     * Method under test: {@link LeaveController#editLeave(Integer, String, org.springframework.ui.Model)}
     */
    @Test
    void testEditLeave() throws Exception {
        Leave leave = new Leave();
        leave.setAnnualLeaveBalance(1);
        leave.setAppliedDate("2020-03-01");
        leave.setBirthdayDate("2020-03-01");
        leave.setEmailAddress("42 Main St");
        leave.setEndDate("2020-03-01");
        leave.setFamilyResponsibilityLeaveBalance(1);
        leave.setFirstName("Jane");
        leave.setGender("Gender");
        leave.setId(1);
        leave.setLastName("Doe");
        leave.setLeaveType("Leave Type");
        leave.setSickLeaveBalance(1);
        leave.setStartDate("2020-03-01");
        leave.setStatus("Status");
        leave.setUniqueLeaveNo("Unique Leave No");
        leave.setUsername("janedoe");
        when(this.leaveService.findLeaveByID(anyInt())).thenReturn(leave);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/work-force/apply-leave/{op}/{id}", "Op",
                1);
        MockMvcBuilders.standaloneSetup(this.leaveController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("leave"))
                .andExpect(MockMvcResultMatchers.view().name("/workForce/leaveEdit1"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("/workForce/leaveEdit1"));
    }

    /**
     * Method under test: {@link LeaveController#editLeave(Integer, String, org.springframework.ui.Model)}
     */
    @Test
    void testEditLeave2() throws Exception {
        Leave leave = new Leave();
        leave.setAnnualLeaveBalance(1);
        leave.setAppliedDate("2020-03-01");
        leave.setBirthdayDate("2020-03-01");
        leave.setEmailAddress("42 Main St");
        leave.setEndDate("2020-03-01");
        leave.setFamilyResponsibilityLeaveBalance(1);
        leave.setFirstName("Jane");
        leave.setGender("Gender");
        leave.setId(1);
        leave.setLastName("Doe");
        leave.setLeaveType("Leave Type");
        leave.setSickLeaveBalance(1);
        leave.setStartDate("2020-03-01");
        leave.setStatus("Status");
        leave.setUniqueLeaveNo("Unique Leave No");
        leave.setUsername("janedoe");
        when(this.leaveService.findLeaveByID(anyInt())).thenReturn(leave);
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/work-force/apply-leave/{op}/{id}", "Op", 1);
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.leaveController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("leave"))
                .andExpect(MockMvcResultMatchers.view().name("/workForce/leaveEdit1"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("/workForce/leaveEdit1"));
    }

    /**
     * Method under test: {@link LeaveController#findAll(org.springframework.ui.Model)}
     */
    @Test
    void testFindAll() throws Exception {
        when(this.leaveService.findAllEmployeeLeaves()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/work-force/apply-leave");
        MockMvcBuilders.standaloneSetup(this.leaveController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("leave"))
                .andExpect(MockMvcResultMatchers.view().name("/workForce/leaves"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("/workForce/leaves"));
    }

    /**
     * Method under test: {@link LeaveController#findAll(org.springframework.ui.Model)}
     */
    @Test
    void testFindAll2() throws Exception {
        when(this.leaveService.findAllEmployeeLeaves()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/work-force/apply-leave");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.leaveController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("leave"))
                .andExpect(MockMvcResultMatchers.view().name("/workForce/leaves"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("/workForce/leaves"));
    }
}

