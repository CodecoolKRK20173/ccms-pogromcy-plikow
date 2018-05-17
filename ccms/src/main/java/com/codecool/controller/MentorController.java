package com.codecool.controller;

import com.codecool.model.Assignment;
import com.codecool.model.DataContainer;
import com.codecool.model.User;

import java.util.List;

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
    public void editStudent(User student, String[] informations) {
        if (informations[0].equals("name")) {
            student.setName(informations[1]);
        } else if (informations[0].equals("surname")) {
            student.setSurname(informations[1]);
        } else if (informations[0].equals("e-mail")) {
            student.setEmail(informations[1]);
        }
    }


}
