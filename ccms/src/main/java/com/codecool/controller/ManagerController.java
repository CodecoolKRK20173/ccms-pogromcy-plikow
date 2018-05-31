package com.codecool.controller;

import com.codecool.model.DataContainer;
import com.codecool.model.User;
import java.util.List;
import java.util.Map;

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

    public boolean addMentor(String[] informations) {
        return data.addMentor(informations[0], informations[1], informations[2], informations[3], informations[4]);
    }

    public User getMentor(String login) {
        return data.getMentor(login);
    }

    public void removeMentor(User user) {
        data.deleteMentor(user);
    }

    public void editMentor(User mentor, Map<String,String> userData) {
        mentor.setName(userData.get("name"));
        mentor.setSurname(userData.get("surname"));
        mentor.setEmail(userData.get("email"));
    }


    public boolean addEmployee(String[] informations) {
        return data.addRegularEmployee(informations[0], informations[1], informations[2], informations[3], informations[4]);
    }

    public void removeEmployee(User user) {

        data.deleteRegularEmployee(user);
    }

    public List<User> getEmployees() {
        return data.getRegularEmployees();
    }

    public User getEmployee(String login) {
        return data.getRegularEmployee(login);
    }
}
