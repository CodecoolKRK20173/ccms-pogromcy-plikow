package com.codecool.controller;

import com.codecool.dao.UsersDAO;
import com.codecool.model.DataContainer;
import com.codecool.model.User;

import java.util.List;

public class RegularEmployeeController {

    private UsersDAO dao;

    public RegularEmployeeController() {
        this.dao = new UsersDAO();

    }
    public List<User> getStudents() {
        return dao.getAllRoles("student");

    }
}
