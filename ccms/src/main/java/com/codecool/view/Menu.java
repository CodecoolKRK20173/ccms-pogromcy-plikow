package com.codecool.view;

public abstract class Menu {
    private View view;
    private UserInput userInput;
    protected String[] options;
    protected String label;

    protected abstract void executeOption(int option);

    public void run() {
        boolean isRunning = true;
        while (isRunning) {
            view.print();
            view.print(label);
            view.print("0: quit");
            view.printOptions(options);

            view.print("Choose option:");
            int userChoice = userInput.chooseOption();

            if (userChoice == 0) {
                isRunning = false;
            } else {
                executeOption(userChoice);
                view.print();
            }
        }
    }
}

