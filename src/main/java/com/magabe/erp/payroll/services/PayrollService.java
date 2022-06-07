package com.magabe.erp.payroll.services;

import com.magabe.erp.payroll.entities.Payroll;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PayrollService {

   void  SavePayroll(Payroll payroll);
   List<Payroll> findAllPayroll();
}
