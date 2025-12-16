package com.eps.service;

import com.eps.dao.PayrollRepository;
import com.eps.model.Payroll;

public class PayrollService {

    private final PayrollRepository repo;

    public PayrollService(PayrollRepository repo) {
        this.repo = repo;
    }

    public Payroll calculate(int empId, double basic, double overtime, double tax) {
        Payroll payroll = new Payroll(empId, basic, overtime, tax); // variable name fix
        repo.save(payroll);
        return payroll;
    }
}
