package com.magabe.erp.payroll.repositories;

import com.magabe.erp.payroll.entities.Payroll;
import org.springframework.data.repository.CrudRepository;

public interface PayrollRepository extends CrudRepository<Payroll,Long> {
}
