package com.codecool.controller;

import com.codecool.model.Assignment;
import com.codecool.model.DataContainer;
import com.codecool.model.User;

import java.util.List;
import java.util.Map;

public class MentorController {
    private DataContainer data;

    public MentorController() {
        this.data = DataContainer.getInstance();
    }
    public List<User> getStudents() {
        return data.getStudents();
    }
    public void createAssignment(String description) {
        data.createAssignment(description);
    }
    public User getStudent(String logIn) {
        return data.getStudent(logIn);
    }
    public void gradeAssignment(Assignment assignment, int grade) {
        assignment.setGrade(grade);
    }
    public void addStudent(String[] informations) {
        data.addStudent(informations[0], informations[1], informations[2], informations[3], informations[4]);
    }
    public void removeStudent(User student) {
        data.deleteStudent(student);
    }

    public void editStudent(User student, Map<String,String> userData) {
        student.setName(userData.get("name"));
        student.setSurname(userData.get("surname"));
        student.setEmail(userData.get("email"));
    }

    public String[] getContactInformations(User user) {
        return new String[]{
                user.getName(),
                user.getSurname(),
                user.getEmail()
        };
    }
}
