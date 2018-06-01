package com.codecool.controller;

import com.codecool.dao.UsersDAO;
import com.codecool.model.DataContainer;
import com.codecool.model.User;
import java.util.List;
import java.util.Map;

public class ManagerController {

    private UsersDAO dao;
    private DataContainer data;

    public ManagerController() {
        this.dao = new UsersDAO();
        this.data = DataContainer.getInstance();
    }

    public List<User> getStudents() {
        return dao.getAllRoles("student");
    }

    public List<User> getMentors() {
        return dao.getAllRoles("mentor");
    }

    public void addMentor(String[] informations) {

        dao.insertData(new User(informations[0], informations[1], informations[2], informations[3], informations[4], "mentor"));
    }

    public User getMentor(String login) {
        return dao.getData(login);
    }

    public void removeMentor(User user) {
        dao.deleteData(user);
    }

    public void editMentor(User mentor, Map<String,String> userData) {
        mentor.setName(userData.get("name"));
        mentor.setSurname(userData.get("surname"));
        mentor.setEmail(userData.get("email"));
        dao.updateData(mentor);
    }


    public void addEmployee(String[] informations) {
        dao.insertData(new User(informations[0], informations[1], informations[2], informations[3], informations[4],"regular"));

    }

    public void removeEmployee(User user) {

        dao.deleteData(user);
    }

    public List<User> getEmployees() {
        return dao.getAllRoles("regular");
    }

    public User getEmployee(String login) {
        return dao.getData(login);
    }
}
