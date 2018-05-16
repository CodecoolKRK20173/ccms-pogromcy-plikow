package com.codecool.model;

import java.util.ArrayList;
import java.util.List;

public class Student extends User{
    final static String type = "student";
    private List<Assignment> assigments;

    public Student(String id, String password, String name, String surname, String eMail) {
        super(id, password, name, surname, eMail, type);
        assigments = new ArrayList<Assignment>();
    }

    public String[] getContactData() {
        String[] result = new String[] {
                this.getName(),
                this.getSurname(),
                this.geteMail()
        };
        return result;
    }

    public List<Assignment> getDoneAssigment() {
        List<Assignment> doneAssigments = new ArrayList<Assignment>();

        for (Assignment assignment: assigments) {
            if (assignment.getStatus()) {
                doneAssigments.add(assignment);
            }
        }

        return doneAssigments;
    }
}
