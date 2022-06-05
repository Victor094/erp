package com.magabe.erp.workForce.services;

import com.magabe.erp.workForce.entities.Employee;
import com.magabe.erp.workForce.entities.Leave;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    void saveEmployee(Employee employee);
    List<Employee> findAllEmployees();
    void findEmployeeByID(int id);


}
