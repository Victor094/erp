package com.magabe.erp.workForce.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.Test;

class EmployeeTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link Employee}
     *   <li>{@link Employee#setAddress(String)}
     *   <li>{@link Employee#setDateOfBirth(Date)}
     *   <li>{@link Employee#setEmail(String)}
     *   <li>{@link Employee#setFirstname(String)}
     *   <li>{@link Employee#setFullName(String)}
     *   <li>{@link Employee#setGender(String)}
     *   <li>{@link Employee#setHireDate(Date)}
     *   <li>{@link Employee#setId(Integer)}
     *   <li>{@link Employee#setIdNumber(String)}
     *   <li>{@link Employee#setInitials(String)}
     *   <li>{@link Employee#setLastname(String)}
     *   <li>{@link Employee#setMaritalStatus(String)}
     *   <li>{@link Employee#setMobile(String)}
     *   <li>{@link Employee#setOthername(String)}
     *   <li>{@link Employee#setPhone(String)}
     *   <li>{@link Employee#setTitle(String)}
     *   <li>{@link Employee#setUsername(String)}
     *   <li>{@link Employee#getAddress()}
     *   <li>{@link Employee#getDateOfBirth()}
     *   <li>{@link Employee#getEmail()}
     *   <li>{@link Employee#getFirstname()}
     *   <li>{@link Employee#getFullName()}
     *   <li>{@link Employee#getGender()}
     *   <li>{@link Employee#getHireDate()}
     *   <li>{@link Employee#getId()}
     *   <li>{@link Employee#getIdNumber()}
     *   <li>{@link Employee#getInitials()}
     *   <li>{@link Employee#getLastname()}
     *   <li>{@link Employee#getMaritalStatus()}
     *   <li>{@link Employee#getMobile()}
     *   <li>{@link Employee#getOthername()}
     *   <li>{@link Employee#getPhone()}
     *   <li>{@link Employee#getTitle()}
     *   <li>{@link Employee#getUsername()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Employee actualEmployee = new Employee();
        actualEmployee.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        actualEmployee.setDateOfBirth(fromResult);
        actualEmployee.setEmail("jane.doe@example.org");
        actualEmployee.setFirstname("Jane");
        actualEmployee.setFullName("Dr Jane Doe");
        actualEmployee.setGender("Gender");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult1 = Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant());
        actualEmployee.setHireDate(fromResult1);
        actualEmployee.setId(1);
        actualEmployee.setIdNumber("42");
        actualEmployee.setInitials("Initials");
        actualEmployee.setLastname("Doe");
        actualEmployee.setMaritalStatus("Marital Status");
        actualEmployee.setMobile("Mobile");
        actualEmployee.setOthername("Othername");
        actualEmployee.setPhone("4105551212");
        actualEmployee.setTitle("Dr");
        actualEmployee.setUsername("janedoe");
        assertEquals("42 Main St", actualEmployee.getAddress());
        assertSame(fromResult, actualEmployee.getDateOfBirth());
        assertEquals("jane.doe@example.org", actualEmployee.getEmail());
        assertEquals("Jane", actualEmployee.getFirstname());
        assertEquals("Dr Jane Doe", actualEmployee.getFullName());
        assertEquals("Gender", actualEmployee.getGender());
        assertSame(fromResult1, actualEmployee.getHireDate());
        assertEquals(1, actualEmployee.getId().intValue());
        assertEquals("42", actualEmployee.getIdNumber());
        assertEquals("Initials", actualEmployee.getInitials());
        assertEquals("Doe", actualEmployee.getLastname());
        assertEquals("Marital Status", actualEmployee.getMaritalStatus());
        assertEquals("Mobile", actualEmployee.getMobile());
        assertEquals("Othername", actualEmployee.getOthername());
        assertEquals("4105551212", actualEmployee.getPhone());
        assertEquals("Dr", actualEmployee.getTitle());
        assertEquals("janedoe", actualEmployee.getUsername());
    }
}

