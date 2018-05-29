package com.codecool.view;

import com.codecool.controller.LogInController;
// resolve login repetition
public class LogInMenu extends Menu {
    private Menu menu;
    private LogInController logInController;

    public LogInMenu() {
        loadAllData();
        this.label = "CCMS:";
        this.options = new String[] {
            "Log in",
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
                Menu menu = logInController.verifyUserAccount(logIn, password);
                if (menu != null) {
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
