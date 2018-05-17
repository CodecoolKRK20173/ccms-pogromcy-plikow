package com.codecool.view;

public abstract class Menu {
    protected UserFileHandler fileHandler = new UserFileHandler();
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
                fileHandler.saveUsers();
                isRunning = false;
            } else {
                view.print();
                executeOption(userChoice);
                view.print();
            }
        }
    }
}

