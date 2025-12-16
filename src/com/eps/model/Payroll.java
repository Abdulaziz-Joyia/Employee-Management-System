package com.eps.model;

public class Payroll {
    private int employeeId;
    private double basicSalary;
    private double overtime;
    private double tax;
    private double netSalary;

    public Payroll() {}

    public Payroll(int employeeId, double basicSalary, double overtime, double tax) {
        this.employeeId = employeeId;
        this.basicSalary = basicSalary;
        this.overtime = overtime;
        this.tax = tax;
        this.netSalary = calculateNetSalary();
    }

    public double calculateNetSalary() {
        return basicSalary + overtime - tax;
    }

    public int getEmployeeId() { return employeeId; }
    public double getBasicSalary() { return basicSalary; }
    public double getOvertime() { return overtime; }
    public double getTax() { return tax; }
    public double getNetSalary() { return netSalary; }

    @Override
    public String toString() {
        return employeeId + "," + basicSalary + "," + overtime + "," + tax + "," + netSalary;
    }
}
