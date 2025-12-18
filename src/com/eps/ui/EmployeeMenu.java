package com.eps.ui;

import com.eps.model.Employee;
import com.eps.service.EmployeeService;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class EmployeeMenu {

    private final EmployeeService service;
    private final Scanner sc = new Scanner(System.in);

    public EmployeeMenu(EmployeeService service) {
        this.service = service;
    }

    public void show() {
        while (true) {

            System.out.println("\n=== Employee Menu ===");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. View All Employees");
            System.out.println("5. Search by ID");
            System.out.println("0. Back");
            System.out.print("Choose: ");

            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1 -> add();
                case 2 -> update();
                case 3 -> delete();
                case 4 -> list();
                case 5 -> search();
                case 0 -> { return; }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private void add() {
        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Designation: ");
        String desig = sc.nextLine();

        System.out.print("Basic Salary: ");
        double sal = sc.nextDouble();
        sc.nextLine();

        System.out.print("Phone: ");
        String phone = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        service.addEmployee(name, desig, sal, phone, email);
        System.out.println("Employee Added Successfully!");
    }

    private void update() {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        Optional<Employee> opt = service.getEmployeeById(id);

        if (opt.isEmpty()) {
            System.out.println("Employee Not Found!");
            return;
        }

        Employee e = opt.get();

        System.out.print("New Name (" + e.getName() + "): ");
        e.setName(sc.nextLine());

        System.out.print("New Designation (" + e.getDesignation() + "): ");
        e.setDesignation(sc.nextLine());

        System.out.print("New Salary (" + e.getBasicSalary() + "): ");
        e.setBasicSalary(sc.nextDouble());
        sc.nextLine();

        System.out.print("New Phone (" + e.getPhone() + "): ");
        e.setPhone(Integer.parseInt(sc.nextLine()));

        System.out.print("New Email (" + e.getEmail() + "): ");
        e.setEmail(Integer.parseInt(sc.nextLine()));

        service.updateEmployee(e);
        System.out.println("Employee Updated!");
    }

    private void delete() {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        if (service.deleteEmployee(id))
            System.out.println("Deleted Successfully!");
        else
            System.out.println("Employee Not Found!");
    }

    private void list() {
        List<Employee> list = service.getAllEmployees();
        list.forEach(System.out::println);
    }

    private void search() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        Optional<Employee> emp = service.getEmployeeById(id);
        System.out.println(emp.orElse(null));
    }
}
