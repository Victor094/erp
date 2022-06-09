package com.magabe.erp.workForce.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LeaveTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link Leave}
     *   <li>{@link Leave#setAnnualLeaveBalance(int)}
     *   <li>{@link Leave#setAppliedDate(String)}
     *   <li>{@link Leave#setBirthdayDate(String)}
     *   <li>{@link Leave#setEmailAddress(String)}
     *   <li>{@link Leave#setEndDate(String)}
     *   <li>{@link Leave#setFamilyResponsibilityLeaveBalance(int)}
     *   <li>{@link Leave#setFirstName(String)}
     *   <li>{@link Leave#setGender(String)}
     *   <li>{@link Leave#setId(int)}
     *   <li>{@link Leave#setLastName(String)}
     *   <li>{@link Leave#setLeaveType(String)}
     *   <li>{@link Leave#setSickLeaveBalance(int)}
     *   <li>{@link Leave#setStartDate(String)}
     *   <li>{@link Leave#setStatus(String)}
     *   <li>{@link Leave#setUniqueLeaveNo(String)}
     *   <li>{@link Leave#setUsername(String)}
     *   <li>{@link Leave#getAnnualLeaveBalance()}
     *   <li>{@link Leave#getAppliedDate()}
     *   <li>{@link Leave#getBirthdayDate()}
     *   <li>{@link Leave#getEmailAddress()}
     *   <li>{@link Leave#getEndDate()}
     *   <li>{@link Leave#getFamilyResponsibilityLeaveBalance()}
     *   <li>{@link Leave#getFirstName()}
     *   <li>{@link Leave#getGender()}
     *   <li>{@link Leave#getId()}
     *   <li>{@link Leave#getLastName()}
     *   <li>{@link Leave#getLeaveType()}
     *   <li>{@link Leave#getSickLeaveBalance()}
     *   <li>{@link Leave#getStartDate()}
     *   <li>{@link Leave#getStatus()}
     *   <li>{@link Leave#getUniqueLeaveNo()}
     *   <li>{@link Leave#getUsername()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Leave actualLeave = new Leave();
        actualLeave.setAnnualLeaveBalance(1);
        actualLeave.setAppliedDate("2020-03-01");
        actualLeave.setBirthdayDate("2020-03-01");
        actualLeave.setEmailAddress("42 Main St");
        actualLeave.setEndDate("2020-03-01");
        actualLeave.setFamilyResponsibilityLeaveBalance(1);
        actualLeave.setFirstName("Jane");
        actualLeave.setGender("Gender");
        actualLeave.setId(1);
        actualLeave.setLastName("Doe");
        actualLeave.setLeaveType("Leave Type");
        actualLeave.setSickLeaveBalance(1);
        actualLeave.setStartDate("2020-03-01");
        actualLeave.setStatus("Status");
        actualLeave.setUniqueLeaveNo("Unique Leave No");
        actualLeave.setUsername("janedoe");
        assertEquals(1, actualLeave.getAnnualLeaveBalance());
        assertEquals("2020-03-01", actualLeave.getAppliedDate());
        assertEquals("2020-03-01", actualLeave.getBirthdayDate());
        assertEquals("42 Main St", actualLeave.getEmailAddress());
        assertEquals("2020-03-01", actualLeave.getEndDate());
        assertEquals(1, actualLeave.getFamilyResponsibilityLeaveBalance());
        assertEquals("Jane", actualLeave.getFirstName());
        assertEquals("Gender", actualLeave.getGender());
        assertEquals(1, actualLeave.getId());
        assertEquals("Doe", actualLeave.getLastName());
        assertEquals("Leave Type", actualLeave.getLeaveType());
        assertEquals(1, actualLeave.getSickLeaveBalance());
        assertEquals("2020-03-01", actualLeave.getStartDate());
        assertEquals("Status", actualLeave.getStatus());
        assertEquals("Unique Leave No", actualLeave.getUniqueLeaveNo());
        assertEquals("janedoe", actualLeave.getUsername());
    }
}

