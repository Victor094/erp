package com.magabe.erp.workForce.services;

import com.magabe.erp.workForce.entities.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EmployeeService {
    void saveEmployee(Employee employee);
    List<Employee> findAllEmployees();
    Employee findEmployeeByID(int id);


}
