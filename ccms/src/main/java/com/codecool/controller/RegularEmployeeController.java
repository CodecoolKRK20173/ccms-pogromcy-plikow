package com.codecool.controller;

import com.codecool.model.DataContainer;
import com.codecool.model.User;

import java.util.List;

public class RegularEmployeeController {

    private DataContainer data;

    public RegularEmployeeController() {
        this.data = DataContainer.getInstance();

    }
    public List<User> getStudents() {
        return data.getStudents();

    }
}
