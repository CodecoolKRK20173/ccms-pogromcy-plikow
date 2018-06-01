package com.codecool.controller;

import com.codecool.dao.UsersDAO;
import com.codecool.model.User;
import com.codecool.security.PasswordSecurity;
import com.codecool.view.*;


public class LogInController {
    private UsersDAO dao;

    public LogInController() {
        this.dao = new UsersDAO();
    }

    public Menu verifyUserAccount(String logIn, String password) {

        User user = dao.getData(logIn);

        if (user == null) {return null;}
        if (!user.getPassword().equals(PasswordSecurity.getHashPassword(password,PasswordSecurity.intTobytes(user.getSalt())))) {return null;}

        return createMenu(user.getRole(), logIn);
    }

    private Menu createMenu(String role, String logIn) {
        if (role.equals("manager")) return new ManagerMenu();
        else if (role.equals("mentor")) return new MentorMenu();
        else if (role.equals("student")) return new StudentMenu(logIn);
        else if (role.equals("regular")) return new RegularEmployeeMenu();
        else return null;
    }

    private User findUser(String logIn) {
        return dao.getData(logIn);
    }

}
