package com.eps.ui;

import com.eps.model.Payroll;
import com.eps.service.PayrollService;

import java.util.Scanner;

public class PayrollMenu {

    private final PayrollService service;
    private final Scanner sc = new Scanner(System.in);

    public PayrollMenu(PayrollService service) {
        this.service = service;
    }

    public void show() {
        System.out.println("\n=== Payroll System ===");

        int id;
        double basic, ot, tax;

        try {
            System.out.print("Employee ID: ");
            id = Integer.parseInt(sc.nextLine());

            System.out.print("Basic Salary: ");
            basic = Double.parseDouble(sc.nextLine());

            System.out.print("Overtime: ");
            ot = Double.parseDouble(sc.nextLine());

            System.out.print("Tax: ");
            tax = Double.parseDouble(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter numbers only.");
            return;
        }

        Payroll p = service.calculate(id, basic, ot, tax);

        if (p == null) {
            System.out.println("Error: Payroll calculation failed (employee may not exist).");
            return;
        }

        System.out.println("\n**** PAYSLIP ****");
        System.out.println("Employee ID: " + p.getEmployeeId());
        System.out.println("Basic Salary: " + p.getBasicSalary());
        System.out.println("Overtime: " + p.getOvertime());
        System.out.println("Tax: " + p.getTax());
        System.out.println("Net Salary: " + p.getNetSalary());
    }
}
