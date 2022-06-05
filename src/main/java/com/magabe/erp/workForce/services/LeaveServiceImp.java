package com.magabe.erp.workForce.services;

import com.magabe.erp.workForce.entities.Leave;
import com.magabe.erp.workForce.repositories.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeaveServiceImp implements  LeaveService {

    @Autowired
    LeaveRepository leaveRepository;
    @Override
    public List<Leave> findAllEmployeeLeaves() {
        return leaveRepository.findAll();
    }

    @Override
    public void saveLeave(Leave leave) {
        leaveRepository.save(leave);
    }

    @Override
    public Optional<Leave> findLeaveByID(int id) {
        return leaveRepository.findById(id);
    }
}
