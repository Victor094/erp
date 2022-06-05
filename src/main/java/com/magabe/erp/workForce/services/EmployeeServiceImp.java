package com.magabe.erp.workForce.services;

import com.magabe.erp.workForce.entities.Employee;
import com.magabe.erp.workForce.entities.Leave;
import com.magabe.erp.workForce.repositories.EmployeeRepository;
import com.magabe.erp.workForce.repositories.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public void findEmployeeByID(int id) {
        employeeRepository.findById(id);

    }

}
