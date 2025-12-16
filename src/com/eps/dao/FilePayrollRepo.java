package com.eps.dao;


import com.eps.model.Payroll;

import java.io.*;
import java.util.*;

public class FilePayrollRepo implements com.eps.dao.PayrollRepository {

    private final String filePath = "data/payroll.csv";

    public FilePayrollRepo() {
        File f = new File("data");
        if (!f.exists()) f.mkdir();

        File file = new File(filePath);
        try {
            if (!file.exists()) file.createNewFile();
        } catch (Exception ignored) {}
    }

    @Override
    public void save(Payroll p) {
        try (FileWriter fw = new FileWriter(filePath, true)) {
            fw.write(p.toString() + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(Object p) {

    }

    @Override
    public List<Payroll> findAll() {
        List<Payroll> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] p = line.split(",");
                if (p.length >= 4) {  // minimum 4 fields required
                    Payroll pay = new Payroll(
                            Integer.parseInt(p[0]),
                            Double.parseDouble(p[1]),
                            Double.parseDouble(p[2]),
                            Double.parseDouble(p[3])
                    );
                    list.add(pay);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
