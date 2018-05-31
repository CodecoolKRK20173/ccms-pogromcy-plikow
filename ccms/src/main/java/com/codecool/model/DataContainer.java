package com.codecool.model;

import javax.jws.soap.SOAPBinding;
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

    public void createAssignment(String description) {
        Assignment assignment = new Assignment(description);
        assignments.add(assignment);
    }

    public boolean addStudent(String login, String password, String name, String surname, String eMail) {
        if (!isLoginUnique(login)) return false;
        User student = new Student(login, password, name, surname, eMail);
        students.add(student);
        return true;
    }
    public boolean addMentor(String login, String password, String name, String surname, String eMail) {
        if (!isLoginUnique(login)) return false;
        User mentor = new User(login, password, name, surname, eMail, MENTOR);
        mentors.add(mentor);
        return true;
    }
    public void deleteStudent(User student) {
        students.remove(student);
    }
  
    public void deleteMentor(User mentor) {
        mentors.remove(mentor);
    }

    public boolean addManager(String login, String password, String name, String surname, String eMail) {
        if (!isLoginUnique(login)) return false;
        User manager = new User(login, password, name, surname, eMail, MANAGER);
        managers.add(manager);
        return true;
    }

    public void deleteManager(User manager) {
        managers.remove(manager);
    }

    public boolean addRegularEmployee(String login, String password, String name, String surname, String eMail) {
        if (!isLoginUnique(login)) return false;
        User regularEmployee = new User(login, password, name, surname, eMail, REGULAR_EMPLOYEE);
        regularEmployees.add(regularEmployee);
        return true;
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
            }
        }
        return null;
    }

    public User getUser(String logIn, List<User> users) {
        for (User user : users) {
            if (user.getLogIn().equals(logIn)) {
                return user;
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

    public List<User> collectUsers() {
        List<User> users = new ArrayList<>();

        users.addAll(this.managers);
        users.addAll(this.mentors);
        users.addAll(this.students);
        users.addAll(this.regularEmployees);

        return users;
    }

    private boolean isLoginUnique(String login) {
        for (User user: collectUsers()) {
            if (user.getLogIn().equals(login)) return false;
        }
        return true;
    }
}
