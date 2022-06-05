package com.magabe.erp.workForce.services;

import com.magabe.erp.workForce.entities.Leave;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface LeaveService {
    List<Leave> findAllEmployeeLeaves();
    void saveLeave(Leave leave);
    Optional<Leave> findLeaveByID(int id);


}
