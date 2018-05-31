package com.codecool.controller;

import com.codecool.model.DataContainer;
import com.codecool.model.User;
import com.codecool.security.PasswordSecurity;
import com.codecool.view.*;

import java.util.ArrayList;
import java.util.List;

public class LogInController {
    private DataContainer dataContainer;

    public LogInController() {
        dataContainer = DataContainer.getInstance();
    }

    public Menu verifyUserAccount(String logIn, String password) {
        User user = dataContainer.getUser(logIn);

        if (user == null) {return null;}

        if (isNotPasswordValid(user, password)) {return null;}

        return createMenu(user.getRole(), logIn);
    }

    private boolean isNotPasswordValid(User user, String passwordToValidate) {
        String password = user.getPassword();
        byte[] salt = dataContainer.getSalt(user.getLogIn());
        passwordToValidate = PasswordSecurity.getHashPassword(passwordToValidate, salt);

        if (!password.equals(passwordToValidate)) return true;
        else return false;
    }

    private Menu createMenu(String role, String logIn) {
        if (role.equals("manager")) return new ManagerMenu();
        else if (role.equals("mentor")) return new MentorMenu();
        else if (role.equals("student")) return new StudentMenu(logIn);
        else if (role.equals("mentor")) return new RegularEmployeeMenu();
        else return null;
    }

    public void createManagerIfNotExist() {
        User user = dataContainer.getUser("jurek");
        if (user == null) {
            createManager();
        }
    }

    private void createManager() {
        dataContainer.addManager("jurek", "1234", "jurek", "boss", "boss@codecool.com");
    }
}
