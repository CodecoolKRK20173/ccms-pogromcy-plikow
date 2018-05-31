package com.codecool.controller;

import com.codecool.model.DataContainer;
import com.codecool.model.User;
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

        if (!user.getPassword().equals(password)) {return null;}

        return createMenu(user.getRole(), logIn);
    }

    private Menu createMenu(String role, String logIn) {
        if (role.equals("manager")) return new ManagerMenu();
        else if (role.equals("mentor")) return new MentorMenu();
        else if (role.equals("student")) return new StudentMenu(logIn);
        else if (role.equals("mentor")) return new RegularEmployeeMenu();
        else return null;
    }
}
