package com.codecool.model;

import com.codecool.dao.UsersDAO;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;

public class DataContainer {
    private UsersDAO usersDAO = new UsersDAO();
    private List<Student> students;
    private List<Assignment> assignments;
    private static DataContainer instance;

    private DataContainer() {
        this.students = new ArrayList<>();
        this.assignments = new ArrayList<>();
    }

    public static DataContainer getInstance() {
        if (instance == null) {
            instance = new DataContainer();
        }
        return instance;
    }


    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void createAssignment(String description) {
        Assignment assignment = new Assignment(description);
        assignments.add(assignment);
    }

    public void addStudent(String login, String password, String name, String surname, String eMail) {
        User student = new Student(login, password, name, surname, eMail);
        students.add((Student) student);
    }
    public void deleteStudent(User student) {
        students.remove(student);
    }


    public User getStudent(String logIn) {
        for (User student : students) {
            if (student.getLogIn().equals(logIn)) {
                return student;
            }
        }
        return null;
    }

    public User[] getStudents() {
        return usersDAO.getAllUsersWithRoles("student").toArray(new User[0]);

    }
}
