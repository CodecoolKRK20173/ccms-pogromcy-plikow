package com.codecool.controller;

import com.codecool.dao.UsersDAO;
import com.codecool.model.Assignment;
import com.codecool.model.DataContainer;
import com.codecool.model.Student;
import com.codecool.model.User;

import java.util.ArrayList;
import java.util.List;

public class StudentController {
    private UsersDAO dao;
    private DataContainer dataContainer;

    public StudentController() {
        this.dao = new UsersDAO();
        this.dataContainer = DataContainer.getInstance();
    }

    public List<String> getGrades(String logIn) {
        Student student = (Student) dataContainer.getStudent(logIn);
        List<String> result = new ArrayList<String>();

        if (student == null) {
            return null;
        }

        for (Assignment assignment: student.getDoneAssignment()) {
            result.add(assignment.toString());
        }

        return result;
    }

    public List<Assignment> getAssignments(String logIn) {
        Student student = (Student) dataContainer.getStudent(logIn);
        return student.getAssigments();
    }

    public List<Assignment> getAssignmentPool() {
        return dataContainer.getAssignments();
    }

    public void addAssignment(Assignment assignment, String logIn) {
        Student student = (Student) dataContainer.getStudent(logIn);

        if (student == null) {return;}

        assignment = assignment.copy();
        assignment.setLogin(logIn);
        student.addAssignment(assignment);
    }

    public void submitAssignment(Assignment assignment, String solution) {
        assignment.setSolution(solution);
        assignment.markDown();
    }
}
