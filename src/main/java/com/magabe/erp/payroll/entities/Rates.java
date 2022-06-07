package com.magabe.erp.payroll.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Rates {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    public  int overTimeRates;
    private int normalRatess;



}
