package com.codecool.controller;

import com.codecool.model.User;

public class LogInController {
    public boolean validateUserAccount(String logIn, String password, String type) {
        User user = findUser(logIn);

        if (user == null) {return false;}

        if (!user.getPassword().equals(password)) {return false;}

        if (!user.getType().equals(type)) {return false;}

        return true;
    }

    private User findUser(String logIn) {
        return null;
    }
}
