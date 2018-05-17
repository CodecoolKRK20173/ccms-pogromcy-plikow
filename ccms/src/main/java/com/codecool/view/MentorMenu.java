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
                controller.addStudent(collectInformations());
                break;
            }
            case 6: {
                Student student = (Student) chooseStudent();
                if (student != null) controller.removeStudent(student);
                break;
            }
            case 7: {
                Student student = (Student) chooseStudent();
                String[] contactInformations = controller.getContactInformations(student);
                if (student != null) controller.editStudent(student, chooseInformationToChange(contactInformations));
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
    private String[] chooseInformationToChange(String[] contactInformations) {

        String[] informations = new String[2];
        informations[0] = null;
        boolean isEditing = true;
        while (isEditing) {
            view.printEditMenu(contactInformations);
            int option = UserInput.getInt("What do you want to change? ");
            switch (option) {
                case 0: {
                    isEditing = false;
                    break;
                }

                case 1:
                    informations[0] = "name";
                    contactInformations[0] = UserInput.getString("New name");
                    break;
                case 2:
                    informations[0] = "surname";
                    contactInformations[1] = UserInput.getString("New Surname");
                    break;
                case 3:
                    informations[0] = "e-mail";
                    contactInformations[2] = UserInput.getString("New E-mail");
                    break;
                default:
                    view.print("Wrong option!");
                    break;
            }
        }
        if (informations[0] == null) {return null;}
        return contactInformations;
    }
}
