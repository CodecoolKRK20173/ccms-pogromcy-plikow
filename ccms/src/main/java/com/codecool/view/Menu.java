package com.codecool.view;

import com.codecool.model.AssignmentFileHandler;
import com.codecool.model.UserFileHandler;

import java.util.LinkedHashMap;
import java.util.Map;

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

    protected Map editUser(LinkedHashMap userData) {
        LinkedHashMap replaceData = (LinkedHashMap) userData.clone();
        Object[] keys = userData.keySet().toArray();

        boolean isEditing = true;
        while (isEditing) {
            view.printEditMenu(replaceData);
            int option = UserInput.getInt("What do you want to change?");
            if (option < replaceData.size() && option > 0) {
                String message = String.format("new %s", keys[option - 1]);
                replaceData.put(keys[option - 1], UserInput.getString(message));
            } else {
                if (option == 0)
                    isEditing = false;
                else
                    view.print("Wrong option");
            }
        }
        if (UserInput.isAccept("Save changes")) {
            return replaceData;
        } else {
            return userData;
        }
    }



    protected void saveAllData() {
        userFileHandler.saveUsers();
        userFileHandler.saveSaltMap();
        assignmentFileHandler.saveAssignments();
    }

    protected void loadAllData() {
        userFileHandler.loadUsers();
        userFileHandler.loadSaltMap();
        assignmentFileHandler.loadAssignments();
    }
}

