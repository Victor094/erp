package com.magabe.erp.workForce.entities;

import javax.persistence.*;

@Entity
@Table(name="leave")
public class Leave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String firstName;
    private String lastName;
    private String birthdayDate;
    private String gender;
    private String emailAddress;
    private String startDate ;
    private String endDate ;
    private String leaveType;
    private String status;
    private String appliedDate;
    private String uniqueLeaveNo;
    private int sickLeaveBalance;
    private int annualLeaveBalance;
    private int familyResponsibilityLeaveBalance;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthdayDate() {
        return birthdayDate;
    }

    public void setBirthdayDate(String birthdayDate) {
        this.birthdayDate = birthdayDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAppliedDate() {
        return appliedDate;
    }

    public void setAppliedDate(String appliedDate) {
        this.appliedDate = appliedDate;
    }

    public String getUniqueLeaveNo() {
        return uniqueLeaveNo;
    }

    public void setUniqueLeaveNo(String uniqueLeaveNo) {
        this.uniqueLeaveNo = uniqueLeaveNo;
    }

    public int getSickLeaveBalance() {
        return sickLeaveBalance;
    }

    public void setSickLeaveBalance(int sickLeaveBalance) {
        this.sickLeaveBalance = sickLeaveBalance;
    }

    public int getAnnualLeaveBalance() {
        return annualLeaveBalance;
    }

    public void setAnnualLeaveBalance(int annualLeaveBalance) {
        this.annualLeaveBalance = annualLeaveBalance;
    }

    public int getFamilyResponsibilityLeaveBalance() {
        return familyResponsibilityLeaveBalance;
    }

    public void setFamilyResponsibilityLeaveBalance(int familyResponsibilityLeaveBalance) {
        this.familyResponsibilityLeaveBalance = familyResponsibilityLeaveBalance;
    }
}
