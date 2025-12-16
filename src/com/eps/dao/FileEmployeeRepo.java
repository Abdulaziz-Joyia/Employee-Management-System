package com.eps.dao;

import com.eps.model.Employee;

import java.io.*;
import java.util.*;

public class FileEmployeeRepo implements EmployeeRepository {

    private final String filePath = "data/employees.csv";
    private final Map<Integer, Employee> store = new HashMap<>();

    public FileEmployeeRepo() {
        // make sure data folder exists
        File dir = new File("data");
        if (!dir.exists()) {
            dir.mkdir();
        }
        loadFromFile();
    }

    // ---------- LOAD FILE ----------
    private void loadFromFile() {
        File file = new File(filePath);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] p = line.split(",");
                if (p.length != 6) continue;

                Employee e = new Employee(
                        Integer.parseInt(p[0]),
                        p[1],
                        p[2],
                        Double.parseDouble(p[3]),
                        p[4],
                        p[5]
                );
                store.put(e.getId(), e);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ---------- SAVE FILE ----------
    private void saveToFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filePath))) {
            for (Employee e : store.values()) {
                pw.println(
                        e.getId() + "," +
                                e.getName() + "," +
                                e.getDesignation() + "," +
                                e.getBasicSalary() + "," +
                                e.getPhone() + "," +
                                e.getEmail()
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int generateId() {
        if (store.isEmpty()) return 1;
        return Collections.max(store.keySet()) + 1;
    }

    @Override
    public Employee add(Employee e) {
        int id = generateId();
        e.setId(id);
        store.put(id, e);
        saveToFile();
        return e;
    }

    @Override
    public boolean update(Employee e) {
        if (!store.containsKey(e.getId())) return false;
        store.put(e.getId(), e);
        saveToFile();
        return true;
    }

    @Override
    public boolean delete(int id) {
        return store.remove(id) != null;
    }

    @Override
    public Optional<Employee> findById(int id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Employee> findAll() {
        return new ArrayList<>(store.values());
    }

}