package com.codecool.view;

import com.codecool.controller.LogInController;

public class LogInMenu extends Menu {
    private Menu menu;
    private LogInController logInController;

    public LogInMenu() {
        this.label = "Log in:";
        this.options = new String[] {
            "Log in as manager",
            "Log in as mentor",
            "Log in as student",
            "Log in as regular employee"
        };
        this.logInController = new LogInController();
    }

    protected void executeOption(int option) {
        String logIn;
        String password;
        switch (option) {
            case 1: {
                logIn = UserInput.getString("Login: ");
                password = UserInput.getString("Password");
                if (logInController.validateUserAccount(logIn, password, "manager")) {
                    menu = new ManagerMenu();
                    menu.run();
                } else {
                    view.print("Wrong login or password");
                }
                break;
            }

            case 2: {
                logIn = UserInput.getString("Login: ");
                password = UserInput.getString("Password");
                if (logInController.validateUserAccount(logIn, password, "mentor")) {
                    menu = new MentorMenu();
                    menu.run();
                } else {
                    view.print("Wrong login or password");
                }
                break;
            }

            case 3: {
                logIn = UserInput.getString("Login: ");
                password = UserInput.getString("Password");
                if (logInController.validateUserAccount(logIn, password, "student")) {
                    menu = new StudentMenu(logIn);
                    menu.run();
                } else {
                    view.print("Wrong login or password");
                }
                break;
            }

            case 4: {
                logIn = UserInput.getString("Login: ");
                password = UserInput.getString("Password");
                if (logInController.validateUserAccount(logIn, password, "regularEmployee")) {
                    menu = new RegularEmployeeMenu();
                    menu.run();
                } else {
                    view.print("Wrong login or password");
                }
                break;
            }

            default: {
                view.print("Wrong command");
                break;
            }
        }
    }
}
