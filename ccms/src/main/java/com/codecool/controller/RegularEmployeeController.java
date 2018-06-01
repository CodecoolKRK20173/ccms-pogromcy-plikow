package com.codecool.controller;

import com.codecool.dao.UsersDAO;
import com.codecool.model.User;

import java.util.List;

public class RegularEmployeeController {

    private UsersDAO usersDAO;

    public RegularEmployeeController() {
        this.usersDAO = new UsersDAO();

    }
    public List<User> getStudents() {
        return usersDAO.getAllUsersWithRoles("student");

    }
}
