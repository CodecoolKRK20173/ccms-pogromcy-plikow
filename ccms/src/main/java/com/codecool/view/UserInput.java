package com.codecool.view;

import java.util.Scanner;

class UserInput {
    private Scanner input;

    public int chooseOption() {
        input = new Scanner(System.in);

        try {
            int number = Integer.parseInt(input.next());
            return number;
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
