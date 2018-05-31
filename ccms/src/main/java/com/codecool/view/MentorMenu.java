package com.codecool.view;
import com.codecool.controller.MentorController;
import com.codecool.model.Assignment;
import com.codecool.model.Student;
import com.codecool.model.User;

import java.util.List;

public class MentorMenu extends Menu{
    private View view;
    private MentorController controller;

    public MentorMenu() {
        this.view = new View();
        this.controller = new MentorController();
        this.label = "Mentor";
        this.options = new String[] {
                "List students",
                "Add assignment",
                "Grade assignment",
                "Check attendance",
                "Add student",
                "Remove student",
                "Edit student"
        };
    }

    protected void executeOption(int option) {
        switch (option) {
            case 1: {
                view.printList(controller.getStudents());
                break;
            }
            case 2: {
                controller.createAssignment(UserInput.getString("Description"));
                break;
            }
            case 3: {
                Student student = (Student) chooseStudent();
                Assignment assignment =chooseAssignment(student);
                if (assignment != null) controller.gradeAssignment(assignment, grade());
                break;
            }
            case 4: {
                view.print("Check attendance");
                break;
            }
            case 5: {
                if (controller.addStudent(collectInformations())) {
                    view.print("Successfully added");
                } else {
                    view.print("Login is not Unique");
                }
                break;
            }
            case 6: {
                Student student = (Student) chooseStudent();
                if (student != null) controller.removeStudent(student);
                break;
            }
            case 7: {
                Student student = (Student) chooseStudent();
                if (student != null) controller.editStudent(student, editUser(student.getContactData()));
                break;
            }
            default: {
                System.out.println("Wrong command");
                break;
            }
        }
    }
    private Assignment chooseAssignment(User user) {
        Student student = (Student) user;
        List<Assignment> assignments = student.getDoneAssignment();
        view.printAssignmentList(assignments);
        int id = UserInput.getInt("Choose assignment id") - 1;

        if (id >= assignments.size() || id < 0) {
            view.print("Wrong choice");
            return null;
        }

        return assignments.get(id);
    }
    private User chooseStudent() {
        view.printList(controller.getStudents());
        int id = UserInput.getInt("Choose student id") - 1;

        if (id >= controller.getStudents().size() || id < 0) {
            view.print("Wrong choice");
            return null;
        }

        String logIn = controller.getStudents().get(id).getLogIn();
        return controller.getStudent(logIn);

    }
    private int grade() {
        return UserInput.getInt("Grade assignment");
    }
    private String[] collectInformations() {

        String[] informations = new String[5];

        informations[0] = UserInput.getString("Login");

        informations[1] = UserInput.getString("Password");

        informations[2] = UserInput.getString("Name");

        informations[3] = UserInput.getString("Surname");

        informations[4] = UserInput.getString("Email");

        return informations;
    }
}
