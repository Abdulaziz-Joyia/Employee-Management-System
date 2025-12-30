package com.eps;

import com.eps.dao.FileEmployeeRepo;
import com.eps.dao.FilePayrollRepo;
import com.eps.dao.FileUserRepository;
import com.eps.model.User;
import com.eps.service.AuthService;
import com.eps.service.EmployeeService;
import com.eps.service.PayrollService;
import com.eps.ui.LoginMenu;
import com.eps.ui.MainMenu;

public class App {

    public static void main(String[] args) {

        // 🔐 Login setup
        AuthService authService = new AuthService(new FileUserRepository());
        LoginMenu loginMenu = new LoginMenu(authService);

        User loggedInUser = null;
        while (loggedInUser == null) {
            loggedInUser = loginMenu.showLogin();
        }

        // ✅ Services create karo
        EmployeeService empService =
                new EmployeeService(new FileEmployeeRepo());

        PayrollService payrollService =
                new PayrollService(new FilePayrollRepo());

        // ✅ Login + Services dono pass karo
        MainMenu mainMenu =
                new MainMenu(loggedInUser, empService, payrollService);

        mainMenu.show();
    }
}
//step by step Read in code//
/*
App.java-->1
📄 ui/LoginMenu.java--2
📄 service/AuthService.java---3
📄 dao/FileUserRepository.java--4
📄 model/User.java--5
📄 ui/MainMenu.java--6
📄 ui/EmployeeMenu.java--7
📄 service/EmployeeService.java--8
📄 dao/FileEmployeeRepo.java---9
📄 model/Employee.java--10
📄 ui/PayrollMenu.java--11
📄 service/PayrollService.java--12
📄 dao/FilePayrollRepo.java--13
📄 model/Payroll.java--14
📄 util/InputValidator.java--15

 */