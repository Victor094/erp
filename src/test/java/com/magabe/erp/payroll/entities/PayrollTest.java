package com.magabe.erp.payroll.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PayrollTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link Payroll}
     *   <li>{@link Payroll#setEmail(String)}
     *   <li>{@link Payroll#setFirstName(String)}
     *   <li>{@link Payroll#setGender(String)}
     *   <li>{@link Payroll#setId(Long)}
     *   <li>{@link Payroll#setLastName(String)}
     *   <li>{@link Payroll#setMedicalAid(double)}
     *   <li>{@link Payroll#setNormalRate(double)}
     *   <li>{@link Payroll#setOverTimeRate(double)}
     *   <li>{@link Payroll#setPosition(String)}
     *   <li>{@link Payroll#setSalary(double)}
     *   <li>{@link Payroll#setTax(double)}
     *   <li>{@link Payroll#getEmail()}
     *   <li>{@link Payroll#getFirstName()}
     *   <li>{@link Payroll#getGender()}
     *   <li>{@link Payroll#getId()}
     *   <li>{@link Payroll#getLastName()}
     *   <li>{@link Payroll#getMedicalAid()}
     *   <li>{@link Payroll#getNormalRate()}
     *   <li>{@link Payroll#getOverTimeRate()}
     *   <li>{@link Payroll#getPosition()}
     *   <li>{@link Payroll#getSalary()}
     *   <li>{@link Payroll#getTax()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Payroll actualPayroll = new Payroll();
        actualPayroll.setEmail("jane.doe@example.org");
        actualPayroll.setFirstName("Jane");
        actualPayroll.setGender("Gender");
        actualPayroll.setId(123L);
        actualPayroll.setLastName("Doe");
        actualPayroll.setMedicalAid(10.0d);
        actualPayroll.setNormalRate(10.0d);
        actualPayroll.setOverTimeRate(10.0d);
        actualPayroll.setPosition("Position");
        actualPayroll.setSalary(10.0d);
        actualPayroll.setTax(10.0d);
        assertEquals("jane.doe@example.org", actualPayroll.getEmail());
        assertEquals("Jane", actualPayroll.getFirstName());
        assertEquals("Gender", actualPayroll.getGender());
        assertEquals(123L, actualPayroll.getId().longValue());
        assertEquals("Doe", actualPayroll.getLastName());
        assertEquals(10.0d, actualPayroll.getMedicalAid());
        assertEquals(10.0d, actualPayroll.getNormalRate());
        assertEquals(10.0d, actualPayroll.getOverTimeRate());
        assertEquals("Position", actualPayroll.getPosition());
        assertEquals(10.0d, actualPayroll.getSalary());
        assertEquals(10.0d, actualPayroll.getTax());
    }
}

