package com.eps.model;

public class Employee {
    private int id;
    private String name;
    private String designation;
    private double basicSalary;
    private int phone;
    private int email;

    public Employee() {}

    public Employee(int id, String name, String designation, double basicSalary,int phone, int email) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.basicSalary = basicSalary;
        this.phone = phone;
        this.email = email;
    }

    public Employee(int id, String name, String designation, double basicSalary, String s, String s1) {
    }

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }

    public double getBasicSalary() { return basicSalary; }
    public void setBasicSalary(double basicSalary) { this.basicSalary = basicSalary; }

    public int getPhone() { return phone; }
    public void setPhone(int phone) { this.phone = phone; }

    public int getEmail() { return email; }
    public void setEmail(int email) { this.email = email; }

    @Override
    public String toString() {
        return id + " | " + name + " | " + designation + " | " + basicSalary;
    }
}
