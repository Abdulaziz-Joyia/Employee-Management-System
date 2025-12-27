package com.eps.ui;

import com.eps.model.User;
import com.eps.service.AuthService;

import java.util.Scanner;

public class LoginMenu {

    private AuthService authService;
    private Scanner scanner = new Scanner(System.in);

    public LoginMenu(AuthService authService) {
        this.authService = authService;
    }

    public User showLogin() {
        System.out.println("===== LOGIN =====");
        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        User user = authService.login(username, password);

        if (user == null) {
            System.out.println("❌ Invalid username or password");
        } else {
            System.out.println("✅ Login Successful (" + user.getRole() + ")");
        }
        return user;
    }
}
