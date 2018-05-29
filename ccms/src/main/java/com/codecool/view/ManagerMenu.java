package com.codecool.view;
import com.codecool.controller.ManagerController;
import com.codecool.model.User;

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
                User mentor = chooseMentor();
                if (mentor != null) controller.removeMentor(mentor);
                break;
            }
            case 6: {
                User mentor = chooseMentor();
                if (mentor != null) controller.editMentor(mentor, editUser(mentor.getContactData()));
                break;
            }
            case 7: {
                controller.addEmployee(collectInformations());
                break;
            }
            case 8: {
                User employee = chooseEmployee();
                if (employee != null) controller.removeEmployee(employee);
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

        if (id >= controller.getMentors().size() || id < 0) {
            view.print("Wrong choice");
            return null;
        }

        String login = controller.getMentors().get(id).getLogIn();
        return controller.getMentor(login);
    }

    private User chooseEmployee() {
        view.printList(controller.getEmployees());
        int id = UserInput.getInt("Employee id: ") - 1;

        if (id >= controller.getEmployees().size() || id < 0) {
            view.print("Wrong choice");
            return null;
        }

        String login = controller.getEmployees().get(id).getLogIn();
        return controller.getEmployee(login);
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
//                    informations[1] = UserInput.getString("New name");
                    contactInformations[0] = UserInput.getString("New name");
                    break;
                case 2:
                    informations[0] = "surname";
//                    informations[1] = UserInput.getString("New Surname");
                    contactInformations[1] = UserInput.getString("New Surname");
                    break;
                case 3:
                    informations[0] = "e-mail";
//                    informations[1] = UserInput.getString("New E-mail");
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
