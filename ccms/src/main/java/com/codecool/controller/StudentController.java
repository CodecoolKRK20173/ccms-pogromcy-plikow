package com.codecool.controller;

import com.codecool.model.Assignment;
import com.codecool.model.DataContainer;
import com.codecool.model.Student;
import com.codecool.model.User;

import java.util.ArrayList;
import java.util.List;

public class StudentController {
    private DataContainer dataContainer;

    public StudentController() {
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

    public List<Assignment> getAssignmentPool() {
        return dataContainer.getAssignments();
    }

    public void addAssignment(Assignment assignment, String logIn) {
        Student student = (Student) dataContainer.getStudent(logIn);

        if (student == null) {return;}

        student.addAssignment(assignment);
    }

    public void submitAssignment(Assignment assignment, String solution) {
        assignment.setSolution(solution);
        assignment.markDown();
    }
}
