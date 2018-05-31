package com.codecool.view;

import com.codecool.controller.LogInController;

import java.io.Console;

public class LogInMenu extends Menu {
    private LogInController logInController;

    public LogInMenu() {
        loadAllData();
        this.label = "CCMS:";
        this.options = new String[] {
            "Log in",
        };
        this.logInController = new LogInController();
        logInController.createManagerIfNotExist();
    }

    protected void executeOption(int option) {
        Console console = System.console();
        String logIn;
        String password;
        switch (option) {
            case 1: {
                logIn = UserInput.getString("Login: ");
                view.print("Password:");
                password = new String(console.readPassword());
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
