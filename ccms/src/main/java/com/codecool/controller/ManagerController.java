package com.codecool.controller;

import com.codecool.model.DataContainer;
import com.codecool.model.User;

import java.util.List;

public class ManagerController {

    private DataContainer data;

    public ManagerController() {
        this.data = DataContainer.getInstance();
    }

    public List<User> getStudents() {
        return data.getStudents();
    }

    public List<User> getMentors() {
        return data.getMentors();
    }

    public void addMentor(String[] informations) {

        data.addMentor(informations[0], informations[1], informations[2], informations[3], informations[4]);
    }

    public void removeMentor(User user) {

        data.deleteMentor(user);
    }

    public void editMentor() {
    }

    public void addEmployee(String[] informations) {
        data.addRegularEmployee(informations[0], informations[1], informations[2], informations[3], informations[4]);
    }

    public void removeEmployee(User user) {

        data.deleteRegularEmployee(user);
    }
}
