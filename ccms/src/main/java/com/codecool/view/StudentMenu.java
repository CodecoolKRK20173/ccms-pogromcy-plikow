package com.codecool.view;

import com.codecool.controller.StudentController;
import com.codecool.model.Assignment;

import java.util.List;

public class StudentMenu extends Menu {
    private StudentController controller;
    private String logIn;

    public StudentMenu(String logIn) {
        this.logIn = logIn;
        this.label = "Student";
        this.options = new String[] {
                "View my grades",
                "Get assignment",
                "Submit assignment"
        };
        this.controller = new StudentController();
    }

    protected void executeOption(int option) {
        switch (option) {
            case 1: {
                view.printStringList(controller.getGrades(logIn));
                break;
            }
            case 2: {
                Assignment assignment = chooseObjectFromList(controller.getAssignmentPool());
                controller.addAssignment(assignment, logIn);
                break;
            }
            case 3: {
                Assignment assignment = chooseObjectFromList(controller.getAssignmentPool());
                controller.submitAssignment(assignment, UserInput.getString("Solution: "));
                break;
            }
            default: {
                view.print("Wrong command");
                break;
            }
        }
    }

    private Assignment chooseObjectFromList(List<Assignment> list) {
        view.printAssignmentList(list);
        int userChoice = UserInput.getInt("Choose assignment:") - 1;
        return list.get(userChoice);
    }
}