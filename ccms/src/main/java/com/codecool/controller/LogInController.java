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
        User user = findUser(logIn);

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

    private User findUser(String logIn) {
        for (List<User> users: collectUsers()) {
            User user = dataContainer.getUser(logIn, users);
            if (user != null) return user;
        }
        return null;
    }

    private List<List<User>> collectUsers() {
        List<List<User>> users = new ArrayList<>();

        users.add(dataContainer.getManagers());
        users.add(dataContainer.getMentors());
        users.add(dataContainer.getStudents());
        users.add(dataContainer.getRegularEmployees());

        return users;
    }
}
