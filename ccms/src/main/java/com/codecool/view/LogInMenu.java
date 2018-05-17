package com.codecool.view;

public class LogInMenu extends Menu {
    private Menu menu;

    public LogInMenu() {
        this.label = "Log in:";
        this.options = new String[] {
            "Log in as manager",
            "Log in as mentor",
            "Log in as student",
            "Log in as regular employee"
        };
    }

    protected void executeOption(int option) {
        switch (option) {
            case 1: {
                menu = new ManagerMenu();
                menu.run();
                break;
            }

            case 2: {
                menu = new MentorMenu();
                menu.run();
                break;
            }

            case 3: {
                menu = new StudentMenu("");
                menu.run();
                break;
            }

            case 4: {
                menu = new RegularEmployeeMenu();
                menu.run();
                break;
            }

            default: {
                view.print("Wrong command");
                break;
            }
        }
    }
}
