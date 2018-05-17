package com.codecool.model;

import java.util.ArrayList;
import java.util.List;

public class Student extends User{
    private final static String type = "student";
    private List<Assignment> assigments;

    public Student(String logIn, String password, String name, String surname, String eMail) {
        super(logIn, password, name, surname, eMail, type);
        assigments = new ArrayList<Assignment>();
    }

    public String[] getContactData() {
        return new String[] {
                this.getName(),
                this.getSurname(),
                this.getEmail()
        };
    }

    public List<Assignment> getDoneAssignment() {
        List<Assignment> doneAssigments = new ArrayList<Assignment>();

        for (Assignment assignment: assigments) {
            if (assignment.isDone()) {
                doneAssigments.add(assignment);
            }
        }
        return doneAssigments;
    }

    public List<Assignment> getUnDoneAssignment() {
        List<Assignment> unDoneAssignments = new ArrayList<Assignment>();

        for (Assignment assignment: assigments) {
            if (!assignment.isDone()) {
                unDoneAssignments.add(assignment);
            }
        }
        return unDoneAssignments;
    }

    public List<Assignment> getAssigments() {
        return assigments;
    }
}
