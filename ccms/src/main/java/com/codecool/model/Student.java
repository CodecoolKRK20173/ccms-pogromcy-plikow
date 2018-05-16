package com.codecool.model;

import java.util.ArrayList;
import java.util.List;

public class Student extends User{
    final static String type = "student";
    List<Assignment> assigments;

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


}
