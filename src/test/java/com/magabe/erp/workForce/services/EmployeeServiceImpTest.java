package com.magabe.erp.workForce.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.magabe.erp.workForce.entities.Employee;
import com.magabe.erp.workForce.repositories.EmployeeRepository;
import com.magabe.erp.workForce.repositories.LeaveRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {EmployeeServiceImp.class})
@ExtendWith(SpringExtension.class)
class EmployeeServiceImpTest {
    @MockBean
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeServiceImp employeeServiceImp;

    @MockBean
    private LeaveRepository leaveRepository;

    /**
     * Method under test: {@link EmployeeServiceImp#saveEmployee(Employee)}
     */
    @Test
    void testSaveEmployee() {
        Employee employee = new Employee();
        employee.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        employee.setDateOfBirth(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        employee.setEmail("jane.doe@example.org");
        employee.setFirstname("Jane");
        employee.setFullName("Dr Jane Doe");
        employee.setGender("Gender");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        employee.setHireDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        employee.setId(1);
        employee.setIdNumber("42");
        employee.setInitials("Initials");
        employee.setLastname("Doe");
        employee.setMaritalStatus("Marital Status");
        employee.setMobile("Mobile");
        employee.setOthername("Othername");
        employee.setPhone("4105551212");
        employee.setTitle("Dr");
        employee.setUsername("janedoe");
        when(this.employeeRepository.save((Employee) any())).thenReturn(employee);

        Employee employee1 = new Employee();
        employee1.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant());
        employee1.setDateOfBirth(fromResult);
        employee1.setEmail("jane.doe@example.org");
        employee1.setFirstname("Jane");
        employee1.setFullName("Dr Jane Doe");
        employee1.setGender("Gender");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult1 = Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant());
        employee1.setHireDate(fromResult1);
        employee1.setId(1);
        employee1.setIdNumber("42");
        employee1.setInitials("Initials");
        employee1.setLastname("Doe");
        employee1.setMaritalStatus("Marital Status");
        employee1.setMobile("Mobile");
        employee1.setOthername("Othername");
        employee1.setPhone("4105551212");
        employee1.setTitle("Dr");
        employee1.setUsername("janedoe");
        this.employeeServiceImp.saveEmployee(employee1);
        verify(this.employeeRepository).save((Employee) any());
        assertEquals("42 Main St", employee1.getAddress());
        assertEquals("janedoe", employee1.getUsername());
        assertEquals("Dr", employee1.getTitle());
        assertEquals("4105551212", employee1.getPhone());
        assertEquals("Othername", employee1.getOthername());
        assertEquals("Mobile", employee1.getMobile());
        assertEquals("Marital Status", employee1.getMaritalStatus());
        assertEquals("Doe", employee1.getLastname());
        assertEquals("Initials", employee1.getInitials());
        assertEquals("42", employee1.getIdNumber());
        assertEquals(1, employee1.getId().intValue());
        assertSame(fromResult1, employee1.getHireDate());
        assertEquals("Gender", employee1.getGender());
        assertEquals("Dr Jane Doe", employee1.getFullName());
        assertEquals("Jane", employee1.getFirstname());
        assertEquals("jane.doe@example.org", employee1.getEmail());
        assertSame(fromResult, employee1.getDateOfBirth());
        assertTrue(this.employeeServiceImp.findAllEmployees().isEmpty());
    }

    /**
     * Method under test: {@link EmployeeServiceImp#findAllEmployees()}
     */
    @Test
    void testFindAllEmployees() {
        ArrayList<Employee> employeeList = new ArrayList<>();
        when(this.employeeRepository.findAll()).thenReturn(employeeList);
        List<Employee> actualFindAllEmployeesResult = this.employeeServiceImp.findAllEmployees();
        assertSame(employeeList, actualFindAllEmployeesResult);
        assertTrue(actualFindAllEmployeesResult.isEmpty());
        verify(this.employeeRepository).findAll();
    }

    /**
     * Method under test: {@link EmployeeServiceImp#findAllEmployees()}
     */
    @Test
    void testFindAllEmployees2() {
        when(this.employeeRepository.findAll()).thenThrow(new RuntimeException("An error occurred"));
        assertThrows(RuntimeException.class, () -> this.employeeServiceImp.findAllEmployees());
        verify(this.employeeRepository).findAll();
    }

    /**
     * Method under test: {@link EmployeeServiceImp#findEmployeeByID(int)}
     */
    @Test
    void testFindEmployeeByID() {
        Employee employee = new Employee();
        employee.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        employee.setDateOfBirth(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        employee.setEmail("jane.doe@example.org");
        employee.setFirstname("Jane");
        employee.setFullName("Dr Jane Doe");
        employee.setGender("Gender");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        employee.setHireDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        employee.setId(1);
        employee.setIdNumber("42");
        employee.setInitials("Initials");
        employee.setLastname("Doe");
        employee.setMaritalStatus("Marital Status");
        employee.setMobile("Mobile");
        employee.setOthername("Othername");
        employee.setPhone("4105551212");
        employee.setTitle("Dr");
        employee.setUsername("janedoe");
        Optional<Employee> ofResult = Optional.of(employee);
        when(this.employeeRepository.findById((Integer) any())).thenReturn(ofResult);
        assertSame(employee, this.employeeServiceImp.findEmployeeByID(1));
        verify(this.employeeRepository).findById((Integer) any());
    }

    /**
     * Method under test: {@link EmployeeServiceImp#findEmployeeByID(int)}
     */
    @Test
    void testFindEmployeeByID2() {
        when(this.employeeRepository.findById((Integer) any())).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> this.employeeServiceImp.findEmployeeByID(1));
        verify(this.employeeRepository).findById((Integer) any());
    }

    /**
     * Method under test: {@link EmployeeServiceImp#findEmployeeByID(int)}
     */
    @Test
    void testFindEmployeeByID3() {
        when(this.employeeRepository.findById((Integer) any())).thenThrow(new RuntimeException("An error occurred"));
        assertThrows(RuntimeException.class, () -> this.employeeServiceImp.findEmployeeByID(1));
        verify(this.employeeRepository).findById((Integer) any());
    }
}

