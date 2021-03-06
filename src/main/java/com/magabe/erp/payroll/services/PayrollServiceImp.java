package com.magabe.erp.payroll.services;

import com.magabe.erp.payroll.entities.Payroll;
import com.magabe.erp.payroll.repositories.PayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PayrollServiceImp implements  PayrollService {

    @Autowired
    PayrollRepository payrollRepository;

    @Override
    public void SavePayroll(Payroll payroll) {

        double sal  = payroll.getNormalRate() * 24;
        double totalSal = sal + payroll.getOverTimeRate();
        double medicalAidRate = 0.05;

        payroll.setSalary(totalSal);
        payroll.setMedicalAid(sal*medicalAidRate);

        if(sal <= 30000.00)
            payroll.setTax(sal * 0.10);
        if(sal >= 30000.00 && sal <= 50000.00)
            payroll.setTax(sal * 0.14);
        if(sal >= 50000)
            payroll.setTax(sal *0.16);
        payrollRepository.save(payroll);
    }

    @Override
    public List<Payroll> findAllPayroll() {
        return (List<Payroll>) payrollRepository.findAll();
    }

    @Override
    public void deleteCandidateByid(long id) {
        payrollRepository.deleteById(id);
    }

    @Override
    public Payroll getCandidateById(long id) {
        Optional<Payroll> optional = payrollRepository.findById( id);
        Payroll payroll = null;
        if (optional.isPresent()) {
            payroll = optional.get();
        } else {
            throw new RuntimeException(" Candidate not found for id :: " + id);
        }
        return payroll;    }
}
