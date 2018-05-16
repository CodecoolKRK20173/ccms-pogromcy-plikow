package com.codecool.model;

import java.util.ArrayList;
import java.util.List;

public class DataContainer {
    private static final String MENTOR = "mentor";
    private List<User> users;
    private List<User> students;
    private List<User> mentors;
    private List<Assignment> assignments;

    public DataContainer() {
        this.users = new ArrayList<User>();
        this.students = new ArrayList<User>();
        this.mentors = new ArrayList<User>();
        this.assignments = new ArrayList<Assignment>();
    }

    public List<User> getUsers() {
        return users;
    }

    public List<User> getStudents() {
        return students;
    }

    public List<User> getMentors() {
        return mentors;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }
    public void addUser(User user) {
        users.add(user);
    }
    public void addStudent(String login, String password, String name, String surname, String eMail) {
        User student = new Student(login, password, name, surname, eMail);
        students.add(student);
        addUser(student);
    }
    public void addMentor(String login, String password, String name, String surname, String eMail) {
        User mentor = new User(login, password, name, surname, eMail, MENTOR);
        mentors.add(mentor);
        addUser(mentor);
    }
    public void deleteStudent(User student) {
        students.remove(student);
        deleteUser(student);
    }
    public void deleteMentor(User mentor) {
        mentors.remove(mentor);
        deleteUser(mentor);
    }
    public void deleteUser(User user) {
        users.remove(user);
    }
}
