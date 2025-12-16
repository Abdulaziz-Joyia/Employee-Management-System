package com.eps;


import com.eps.dao.FileEmployeeRepo;
import com.eps.dao.FilePayrollRepo;
import com.eps.service.EmployeeService;
import com.eps.service.PayrollService;

import com.eps.ui.MainMenu;


public class App {
    public static void main(String[] args) {

        EmployeeService empService = new EmployeeService(new FileEmployeeRepo());
        PayrollService payrollService = new PayrollService(new FilePayrollRepo());

        MainMenu menu = new MainMenu(empService, payrollService);

        menu.start();
    }
}
//1. App.java (Entry Point)
//
//Sab se pehle yahan se start karein
//
//📁 src/com.eps/App
//
//Ye main class hoti hai
//
//Program execution yahin se start hota hai
//
//Yahan usually:
//
//MainMenu call hota hai
//
//Application flow start hota hai
//
//👉 Pehle ye file read karein
//
//✅ 2. UI Layer (Menus)
//
//📁 src/com.eps/ui
//
//Is order mein read karein:
//
//1️⃣ MainMenu
//
//Overall system ka control
//
//Employee / Payroll options yahin se choose hoti hain
//
//2️⃣ EmployeeMenu
//
//Employee add, view, update, delete options
//
//3️⃣ PayrollMenu
//
//Salary, payroll related options
//
//👉 UI se aap ko user flow samajh aata hai
//
//✅ 3. Service Layer (Business Logic)
//
//📁 src/com.eps/service
//
//Is order mein:
//
//1️⃣ EmployeeService
//
//Employee related logic
//
//UI → Service → DAO ka flow
//
//2️⃣ PayrollService
//
//Payroll calculation / processing logic
//
//👉 Yahan aap ko actual system ka dimagh (logic) samajh aata hai
//
//✅ 4. DAO Layer (Data Access)
//
//📁 src/com.eps/dao
//
//Is order mein read karein:
//
//1️⃣ EmployeeRepository (Interface)
//
//Employee ke data ke rules define karta hai
//
//2️⃣ FileEmployeeRepo
//
//Employee data file mein save/read karta hai
//
//3️⃣ PayrollRepository (Interface)
//
//4️⃣ FilePayrollRepo
//
//Payroll data file handling
//
//👉 Ye layer file handling & data storage explain karti hai