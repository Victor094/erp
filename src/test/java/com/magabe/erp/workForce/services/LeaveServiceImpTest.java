package com.magabe.erp.workForce.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.magabe.erp.workForce.entities.Leave;
import com.magabe.erp.workForce.repositories.LeaveRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {LeaveServiceImp.class})
@ExtendWith(SpringExtension.class)
class LeaveServiceImpTest {
    @MockBean
    private LeaveRepository leaveRepository;

    @Autowired
    private LeaveServiceImp leaveServiceImp;

    /**
     * Method under test: {@link LeaveServiceImp#findAllEmployeeLeaves()}
     */
    @Test
    void testFindAllEmployeeLeaves() {
        ArrayList<Leave> leaveList = new ArrayList<>();
        when(this.leaveRepository.findAll()).thenReturn(leaveList);
        List<Leave> actualFindAllEmployeeLeavesResult = this.leaveServiceImp.findAllEmployeeLeaves();
        assertSame(leaveList, actualFindAllEmployeeLeavesResult);
        assertTrue(actualFindAllEmployeeLeavesResult.isEmpty());
        verify(this.leaveRepository).findAll();
    }

    /**
     * Method under test: {@link LeaveServiceImp#findAllEmployeeLeaves()}
     */
    @Test
    void testFindAllEmployeeLeaves2() {
        when(this.leaveRepository.findAll()).thenThrow(new RuntimeException("An error occurred"));
        assertThrows(RuntimeException.class, () -> this.leaveServiceImp.findAllEmployeeLeaves());
        verify(this.leaveRepository).findAll();
    }

    /**
     * Method under test: {@link LeaveServiceImp#saveLeave(Leave)}
     */
    @Test
    void testSaveLeave() {
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
        when(this.leaveRepository.save((Leave) any())).thenReturn(leave);

        Leave leave1 = new Leave();
        leave1.setAnnualLeaveBalance(1);
        leave1.setAppliedDate("2020-03-01");
        leave1.setBirthdayDate("2020-03-01");
        leave1.setEmailAddress("42 Main St");
        leave1.setEndDate("2020-03-01");
        leave1.setFamilyResponsibilityLeaveBalance(1);
        leave1.setFirstName("Jane");
        leave1.setGender("Gender");
        leave1.setId(1);
        leave1.setLastName("Doe");
        leave1.setLeaveType("Leave Type");
        leave1.setSickLeaveBalance(1);
        leave1.setStartDate("2020-03-01");
        leave1.setStatus("Status");
        leave1.setUniqueLeaveNo("Unique Leave No");
        leave1.setUsername("janedoe");
        this.leaveServiceImp.saveLeave(leave1);
        verify(this.leaveRepository).save((Leave) any());
        assertEquals(1, leave1.getAnnualLeaveBalance());
        assertEquals("janedoe", leave1.getUsername());
        assertEquals("Unique Leave No", leave1.getUniqueLeaveNo());
        assertEquals("Status", leave1.getStatus());
        assertEquals("2020-03-01", leave1.getStartDate());
        assertEquals(1, leave1.getSickLeaveBalance());
        assertEquals("Leave Type", leave1.getLeaveType());
        assertEquals("Doe", leave1.getLastName());
        assertEquals(1, leave1.getId());
        assertEquals("Gender", leave1.getGender());
        assertEquals("Jane", leave1.getFirstName());
        assertEquals(1, leave1.getFamilyResponsibilityLeaveBalance());
        assertEquals("2020-03-01", leave1.getEndDate());
        assertEquals("42 Main St", leave1.getEmailAddress());
        assertEquals("2020-03-01", leave1.getBirthdayDate());
        assertEquals("2020-03-01", leave1.getAppliedDate());
        assertTrue(this.leaveServiceImp.findAllEmployeeLeaves().isEmpty());
    }

    /**
     * Method under test: {@link LeaveServiceImp#findLeaveByID(int)}
     */
    @Test
    void testFindLeaveByID() {
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
        Optional<Leave> ofResult = Optional.of(leave);
        when(this.leaveRepository.findById((Integer) any())).thenReturn(ofResult);
        assertSame(leave, this.leaveServiceImp.findLeaveByID(1));
        verify(this.leaveRepository).findById((Integer) any());
    }

    /**
     * Method under test: {@link LeaveServiceImp#findLeaveByID(int)}
     */
    @Test
    void testFindLeaveByID2() {
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
        leave.setLeaveType("Family Responsibility");
        leave.setSickLeaveBalance(1);
        leave.setStartDate("2020-03-01");
        leave.setStatus("Status");
        leave.setUniqueLeaveNo("Unique Leave No");
        leave.setUsername("janedoe");
        Optional<Leave> ofResult = Optional.of(leave);
        when(this.leaveRepository.findById((Integer) any())).thenReturn(ofResult);
        assertSame(leave, this.leaveServiceImp.findLeaveByID(1));
        verify(this.leaveRepository).findById((Integer) any());
    }

    /**
     * Method under test: {@link LeaveServiceImp#findLeaveByID(int)}
     */
    @Test
    void testFindLeaveByID3() {
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
        leave.setLeaveType("Annual Leave");
        leave.setSickLeaveBalance(1);
        leave.setStartDate("2020-03-01");
        leave.setStatus("Status");
        leave.setUniqueLeaveNo("Unique Leave No");
        leave.setUsername("janedoe");
        Optional<Leave> ofResult = Optional.of(leave);
        when(this.leaveRepository.findById((Integer) any())).thenReturn(ofResult);
        Leave actualFindLeaveByIDResult = this.leaveServiceImp.findLeaveByID(1);
        assertSame(leave, actualFindLeaveByIDResult);
        assertEquals(0, actualFindLeaveByIDResult.getAnnualLeaveBalance());
        verify(this.leaveRepository).findById((Integer) any());
    }

    /**
     * Method under test: {@link LeaveServiceImp#findLeaveByID(int)}
     */
    @Test
    void testFindLeaveByID4() {
        when(this.leaveRepository.findById((Integer) any())).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> this.leaveServiceImp.findLeaveByID(1));
        verify(this.leaveRepository).findById((Integer) any());
    }

    /**
     * Method under test: {@link LeaveServiceImp#findLeaveByID(int)}
     */
    @Test
    void testFindLeaveByID5() {
        when(this.leaveRepository.findById((Integer) any())).thenThrow(new RuntimeException("An error occurred"));
        assertThrows(RuntimeException.class, () -> this.leaveServiceImp.findLeaveByID(1));
        verify(this.leaveRepository).findById((Integer) any());
    }
}

