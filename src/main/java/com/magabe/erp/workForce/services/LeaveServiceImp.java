package com.magabe.erp.workForce.services;

import com.magabe.erp.workForce.entities.Leave;
import com.magabe.erp.workForce.repositories.LeaveRepository;
import org.codehaus.groovy.ast.stmt.ContinueStatement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
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
    public Leave findLeaveByID(int id) {

        Optional<Leave> optional = leaveRepository.findById(id);
        Leave leave= null;
        if (optional.isPresent()) {
            leave = optional.get();
//            if(leave.getLeaveType().contains("Approved")) {
//                if (Objects.equals(leave.getLeaveType(), "Sick Leave"))
//                    System.out.println(leave.getLeaveType().contains("Sick Leave"));
//            System.out.println(leave.toString());

//                    leave.setSickLeaveBalance(leave.getSickLeaveBalance() - 1);
                if (Objects.equals(leave.getLeaveType(), "Family Responsibility"))
                    System.out.println(leave.getFamilyResponsibilityLeaveBalance() - 1);

//                leave.setFamilyResponsibilityLeaveBalance(leave.getFamilyResponsibilityLeaveBalance() - 1);
                if (Objects.equals(leave.getLeaveType(), "Annual Leave"))
                    leave.setAnnualLeaveBalance(leave.getAnnualLeaveBalance() - 1);
          //  }
        } else {
            throw new RuntimeException(" Candidate not found for id :: " + id);
        }
        return leave;


        //return leaveRepository.findById(id);
    }
}
