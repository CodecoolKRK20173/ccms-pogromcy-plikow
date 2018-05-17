package com.codecool.controller;

import com.codecool.model.DataContainer;
import com.codecool.model.User;

public class LogInController {
    private DataContainer dataContainer;

    public LogInController() {
        dataContainer = DataContainer.getInstance();
    }

    public boolean validateUserAccount(String logIn, String password, String type) {
        User user = findUser(logIn, type);

        if (user == null) {return false;}

        if (!user.getPassword().equals(password)) {return false;}

        return true;
    }

    private User findUser(String logIn, String type) {
        if (type.equals("manager")) {return dataContainer.getManager(logIn);}
        else if (type.equals("mentor")){return dataContainer.getMentor(logIn);}
        else if (type.equals("student")){return dataContainer.getStudent(logIn);}
        else {return dataContainer.getRegularEmployee(logIn);}
    }
}
