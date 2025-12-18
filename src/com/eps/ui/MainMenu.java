package com.eps.ui;

import com.eps.service.EmployeeService;
import com.eps.service.PayrollService;

import java.util.Scanner;

public class MainMenu {

    private final EmployeeService empService;
    private final PayrollService payrollService;
    private final Scanner sc = new Scanner(System.in);

    public MainMenu(EmployeeService empService, PayrollService payrollService) {
        this.empService = empService;
        this.payrollService = payrollService;
    }



    public void start() {
        while (true) {
            System.out.println("\n=== MAIN MENU ===");
            System.out.println("1. Employee Menu");
            System.out.println("2. Payroll Menu");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            int ch = Integer.parseInt(sc.nextLine());

            switch (ch) {

                case 1 -> new EmployeeMenu(empService, sc).show();

                case 2 -> new PayrollMenu(payrollService).show();

                case 0 -> {
                    System.out.println("Goodbye!");
                    return;
                }

                default -> System.out.println("Invalid Choice!");
            }
        }
    }
}
