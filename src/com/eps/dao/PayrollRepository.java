package com.eps.dao;

import com.eps.model.Payroll;

import java.util.List;

public interface PayrollRepository<Payroll> {
    void save(com.eps.model.Payroll p);



    void save(Payroll p);
    List<Payroll> findAll();
}
