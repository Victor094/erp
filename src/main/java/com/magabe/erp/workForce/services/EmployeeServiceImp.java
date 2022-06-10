package com.magabe.erp.workForce.services;

import com.magabe.erp.workForce.entities.Employee;
import com.magabe.erp.workForce.repositories.EmployeeRepository;
import com.magabe.erp.workForce.repositories.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImp implements EmployeeService{

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    LeaveRepository leaveRepository;


    public void saveEmployee(Employee employee) {

        employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findAllEmployees() {
       return employeeRepository.findAll();
    }

    @Override
    public Employee findEmployeeByID(int id) {
        Optional<Employee> optional = employeeRepository.findById(id);
        Employee employee = null;
        if (optional.isPresent()) {
            employee = optional.get();
        } else {
            throw new RuntimeException(" Candidate not found for id :: " + id);
        }
        return employee;

    }

}
