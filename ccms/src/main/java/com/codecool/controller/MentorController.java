package com.codecool.controller;

import com.codecool.dao.UsersDAO;
import com.codecool.model.Assignment;
import com.codecool.model.DataContainer;
import com.codecool.model.User;

import java.util.List;
import java.util.Map;

public class MentorController {
    private UsersDAO dao;
    private DataContainer data;

    public MentorController() {
        this.dao = new UsersDAO();
        this.data = DataContainer.getInstance();
    }
    public List<User> getStudents() {
        return dao.getAllRoles("student");
    }
    public void createAssignment(String description) {
        data.createAssignment(description);
    }
    public User getStudent(String logIn) {
        return dao.getData(logIn);
    }
    public void gradeAssignment(Assignment assignment, int grade) {
        assignment.setGrade(grade);
    }
    public void addStudent(String[] informations) {
        dao.insertData(new User(informations[0], informations[1], informations[2], informations[3], informations[4],"student"));
    }
    public void removeStudent(User student) {
        dao.deleteData(student);
    }

    public void editStudent(User student, Map<String,String> userData) {
        student.setName(userData.get("name"));
        student.setSurname(userData.get("surname"));
        student.setEmail(userData.get("email"));
        dao.updateData(student);
    }
}
