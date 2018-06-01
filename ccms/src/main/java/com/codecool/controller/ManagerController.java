package com.codecool.controller;

import com.codecool.dao.UsersDAO;
import com.codecool.model.DataContainer;
import com.codecool.model.User;
import java.util.List;
import java.util.Map;

public class ManagerController {

    private UsersDAO usersDAO;
    private DataContainer data;

    public ManagerController() {
        this.usersDAO = new UsersDAO();
        this.data = DataContainer.getInstance();
    }

    public List<User> getStudents() {
        return usersDAO.getAllUsersWithRoles("student");
    }

    public List<User> getMentors() {
        return usersDAO.getAllUsersWithRoles("mentor");
    }

    public void addMentor(String[] informations) {

        usersDAO.insertData(new User(informations[0], informations[1], informations[2], informations[3], informations[4], "mentor"));
    }

    public User getMentor(String login) {
        return usersDAO.getData(login);
    }

    public void removeMentor(User user) {
        usersDAO.deleteData(user);
    }

    public void editMentor(User mentor, Map<String,String> userData) {
        mentor.setName(userData.get("name"));
        mentor.setSurname(userData.get("surname"));
        mentor.setEmail(userData.get("email"));
        usersDAO.updateData(mentor);
    }


    public void addEmployee(String[] informations) {
        usersDAO.insertData(new User(informations[0], informations[1], informations[2], informations[3], informations[4],"regular"));

    }

    public void removeEmployee(User user) {

        usersDAO.deleteData(user);
    }

    public List<User> getEmployees() {
        return usersDAO.getAllUsersWithRoles("regular");
    }

    public User getEmployee(String login) {
        return usersDAO.getData(login);
    }
}
