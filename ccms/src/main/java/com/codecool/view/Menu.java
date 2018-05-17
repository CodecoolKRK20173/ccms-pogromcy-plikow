package com.codecool.view;

import com.codecool.model.AssignmentFileHandler;
import com.codecool.model.UserFileHandler;

public abstract class Menu {
    protected UserFileHandler userFileHandler = new UserFileHandler();
    protected AssignmentFileHandler assignmentFileHandler = new AssignmentFileHandler();
    protected View view = new View();
    protected String[] options;
    protected String label;

    protected abstract void executeOption(int option);

    public void run() {
        boolean isRunning = true;
        while (isRunning) {
            view.print();
            view.print(String.format("%s menu", label));
            view.print("(0) Log out");
            view.printOptions(options);

            int userChoice = UserInput.getInt("Choose option: ");

            if (userChoice == 0) {
                saveAllData();
                isRunning = false;
            } else {
                view.print();
                executeOption(userChoice);
                view.print();
            }
        }
    }

    protected void saveAllData() {
        userFileHandler.saveUsers();
        assignmentFileHandler.saveAssignments();
    }

    protected void loadAllData() {
        userFileHandler.loadUsers();
        assignmentFileHandler.loadAssignments();
    }
}

