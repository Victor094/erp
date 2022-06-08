package com.magabe.erp.payroll.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.magabe.erp.payroll.entities.Payroll;
import com.magabe.erp.payroll.repositories.PayrollRepository;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {PayrollServiceImp.class})
@ExtendWith(SpringExtension.class)
class PayrollServiceImpTest {
    @MockBean
    private PayrollRepository payrollRepository;

    @Autowired
    private PayrollServiceImp payrollServiceImp;

    /**
     * Method under test: {@link PayrollServiceImp#SavePayroll(Payroll)}
     */
    @Test
    void testSavePayroll() {
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
        when(this.payrollRepository.save((Payroll) any())).thenReturn(payroll);

        Payroll payroll1 = new Payroll();
        payroll1.setEmail("jane.doe@example.org");
        payroll1.setFirstName("Jane");
        payroll1.setGender("Gender");
        payroll1.setId(123L);
        payroll1.setLastName("Doe");
        payroll1.setMedicalAid(10.0d);
        payroll1.setNormalRate(10.0d);
        payroll1.setOverTimeRate(10.0d);
        payroll1.setPosition("Position");
        payroll1.setSalary(10.0d);
        payroll1.setTax(10.0d);
        this.payrollServiceImp.SavePayroll(payroll1);
        verify(this.payrollRepository).save((Payroll) any());
        assertEquals(24.0d, payroll1.getTax());
        assertEquals(250.0d, payroll1.getSalary());
        assertEquals(12.0d, payroll1.getMedicalAid());
    }

    /**
     * Method under test: {@link PayrollServiceImp#SavePayroll(Payroll)}
     */
    @Test
    void testSavePayroll2() {
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
        when(this.payrollRepository.save((Payroll) any())).thenReturn(payroll);

        Payroll payroll1 = new Payroll();
        payroll1.setEmail("jane.doe@example.org");
        payroll1.setFirstName("Jane");
        payroll1.setGender("Gender");
        payroll1.setId(123L);
        payroll1.setLastName("Doe");
        payroll1.setMedicalAid(10.0d);
        payroll1.setNormalRate(30000.0d);
        payroll1.setOverTimeRate(10.0d);
        payroll1.setPosition("Position");
        payroll1.setSalary(10.0d);
        payroll1.setTax(10.0d);
        this.payrollServiceImp.SavePayroll(payroll1);
        verify(this.payrollRepository).save((Payroll) any());
        assertEquals(115200.0d, payroll1.getTax());
        assertEquals(720010.0d, payroll1.getSalary());
        assertEquals(36000.0d, payroll1.getMedicalAid());
    }

    /**
     * Method under test: {@link PayrollServiceImp#SavePayroll(Payroll)}
     */
    @Test
    void testSavePayroll3() {
        when(this.payrollRepository.save((Payroll) any())).thenThrow(new RuntimeException("An error occurred"));

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
        assertThrows(RuntimeException.class, () -> this.payrollServiceImp.SavePayroll(payroll));
        verify(this.payrollRepository).save((Payroll) any());
    }

    /**
     * Method under test: {@link PayrollServiceImp#findAllPayroll()}
     */
    @Test
    void testFindAllPayroll() {
        when(this.payrollRepository.findAll()).thenThrow(new RuntimeException("An error occurred"));
        assertThrows(RuntimeException.class, () -> this.payrollServiceImp.findAllPayroll());
        verify(this.payrollRepository).findAll();
    }

    /**
     * Method under test: {@link PayrollServiceImp#deleteCandidateByid(long)}
     */
    @Test
    void testDeleteCandidateByid() {
        doNothing().when(this.payrollRepository).deleteById((Long) any());
        this.payrollServiceImp.deleteCandidateByid(123L);
        verify(this.payrollRepository).deleteById((Long) any());
        assertTrue(this.payrollServiceImp.findAllPayroll().isEmpty());
    }

    /**
     * Method under test: {@link PayrollServiceImp#deleteCandidateByid(long)}
     */
    @Test
    void testDeleteCandidateByid2() {
        doThrow(new RuntimeException("An error occurred")).when(this.payrollRepository).deleteById((Long) any());
        assertThrows(RuntimeException.class, () -> this.payrollServiceImp.deleteCandidateByid(123L));
        verify(this.payrollRepository).deleteById((Long) any());
    }

    /**
     * Method under test: {@link PayrollServiceImp#getCandidateById(long)}
     */
    @Test
    void testGetCandidateById() {
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
        Optional<Payroll> ofResult = Optional.of(payroll);
        when(this.payrollRepository.findById((Long) any())).thenReturn(ofResult);
        assertSame(payroll, this.payrollServiceImp.getCandidateById(123L));
        verify(this.payrollRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link PayrollServiceImp#getCandidateById(long)}
     */
    @Test
    void testGetCandidateById2() {
        when(this.payrollRepository.findById((Long) any())).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> this.payrollServiceImp.getCandidateById(123L));
        verify(this.payrollRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link PayrollServiceImp#getCandidateById(long)}
     */
    @Test
    void testGetCandidateById3() {
        when(this.payrollRepository.findById((Long) any())).thenThrow(new RuntimeException("An error occurred"));
        assertThrows(RuntimeException.class, () -> this.payrollServiceImp.getCandidateById(123L));
        verify(this.payrollRepository).findById((Long) any());
    }
}

