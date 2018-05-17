package com.codecool.model;

import java.util.ArrayList;
import java.util.List;

public class DataContainer {
    private static final String MENTOR = "mentor";
    private static final String REGULAR_EMPLOYEE = "regular employee";
    private static final String MANAGER = "manager";
    private List<User> students;
    private List<User> mentors;
    private List<User> managers;
    private List<User> regularEmployees;
    private List<Assignment> assignments;
    private static DataContainer instance;

    private DataContainer() {
        this.students = new ArrayList<User>();
        this.mentors = new ArrayList<User>();
        this.assignments = new ArrayList<Assignment>();
        this.managers = new ArrayList<User>();
        this.regularEmployees = new ArrayList<User>();
    }

    public static DataContainer getInstance() {
        if (instance == null) {
            instance = new DataContainer();
        }
        return instance;
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

    public Assignment createAssignment(String description) {
        Assignment assignment = new Assignment(description);
        assignments.add(assignment);
    }

    public void addStudent(String login, String password, String name, String surname, String eMail) {
        User student = new Student(login, password, name, surname, eMail);
        students.add(student);
    }
    public void addMentor(String login, String password, String name, String surname, String eMail) {
        User mentor = new User(login, password, name, surname, eMail, MENTOR);
        mentors.add(mentor);
    }
    public void deleteStudent(User student) {
        students.remove(student);
    }

    public void deleteMentor(User mentor) {
        mentors.remove(mentor);
    }

    public void addManager(String login, String password, String name, String surname, String eMail) {
        User manager = new User(login, password, name, surname, eMail, MANAGER);
        managers.add(manager);
    }

    public void deleteManager(User manager) {
        managers.remove(manager);
    }

    public void addRegularEmployee(String login, String password, String name, String surname, String eMail) {
        User regularEmployee = new User(login, password, name, surname, eMail, REGULAR_EMPLOYEE);
        regularEmployees.add(regularEmployee);
    }
    public void deleteRegularEmployee(User regularEmployee) {
        regularEmployees.remove(regularEmployee);
    }

    public List<User> getManagers() {
        return managers;
    }

    public List<User> getRegularEmployees() {
        return regularEmployees;
    }

    public User getStudent(String logIn) {
        for (User student : students) {
            if (student.getLogIn().equals(logIn)) {
                return student;
            }
        }
        return null;
    }
    public User getMentor(String logIn) {
        for (User mentor : mentors) {
            if (mentor.getLogIn().equals(logIn)) {
                return mentor;
            }
        }
        return null;
    }
    public User getRegularEmployee(String logIn) {
        for (User regularEmployee : regularEmployees) {
            if (regularEmployee.getLogIn().equals(logIn)) {
                return regularEmployee;
            }
        }
        return null;
    }
    public User getManager(String logIn) {
        for (User manager : managers) {
            if (manager.getLogIn().equals(logIn)) {
                return manager;
            }
        }
        return null;
    }
}
