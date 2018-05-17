package com.codecool.view;
import com.codecool.controller.ManagerController;
import com.codecool.model.User;

import java.util.ArrayList;
import java.util.List;

public class ManagerMenu extends Menu{

    private ManagerController controller;
    private View view;
    public ManagerMenu() {
        this.view = new View();
        this.controller = new ManagerController();
        this.label = "Manager";
        this.options = new String[] {
                "List mentors",
                "List students",
                "List regular employees",
                "Add mentor",
                "Remove mentor",
                "Edit mentor",
                "Add regular employee",
                "Remove regular employee",
        };
    }

    protected void executeOption(int option) {
        switch (option) {
            case 1: {
                view.printList(controller.getMentors());
                break;
            }
            case 2: {
                view.printList(controller.getStudents());
                break;
            }
            case 3: {
                view.printList(controller.getEmployees());
                break;
            }
            case 4: {
                controller.addMentor(collectInformations());
                break;
            }
            case 5: {
                controller.removeMentor(chooseMentor());
                break;
            }
            case 6: {
                User mentor = chooseMentor();
                String[] informations = chooseInformationToChange();
                controller.editMentor(mentor, informations);
                break;
            }
            case 7: {
                controller.addEmployee(collectInformations());
                break;
            }
            case 8: {
                controller.removeEmployee(chooseEmployee());
                break;
            }
            default: {
                view.print("Wrong command");
                break;
            }
        }
    }

    private String[] collectInformations() {

        String[] informations = new String[5];

        informations[0] = UserInput.getString("Login: ");

        informations[1] = UserInput.getString("Password: ");

        informations[2] = UserInput.getString("Name: ");

        informations[3] = UserInput.getString("Surname: ");

        informations[4] = UserInput.getString("Email: ");

        return informations;
    }

    private User chooseMentor() {
        view.printList(controller.getMentors());
        int id = UserInput.getInt("Mentor id: ") - 1;
        String login = controller.getMentors().get(id).getLogIn();
        return controller.getMentor(login);
    }

    private User chooseEmployee() {
        view.printList(controller.getEmployees());
        int id = UserInput.getInt("Employee id: ") - 1;
        String login = controller.getEmployees().get(id).getLogIn();
        return controller.getEmployee(login);
    }

    private String[] chooseInformationToChange() {

        String[] informations = new String[2];
        informations[0] = null;
        while (informations[0] == null) {
            view.printEditMenu();
            int option = UserInput.getInt("What do you want to change? ") - 1;
            switch (option) {
                case 1:
                    informations[0] = "name";
                    informations[1] = UserInput.getString("New name");
                    break;
                case 2:
                    informations[0] = "surname";
                    informations[1] = UserInput.getString("New Surname");
                    break;
                case 3:
                    informations[0] = "e-mail";
                    informations[1] = UserInput.getString("New E-mail");
                    break;
                default:
                    view.print("Wrong option!");
                    break;
            }
        }
        return informations;
    }
}
