package com.codecool.view;
import java.util.Scanner;
import java.util.InputMismatchException;


public class UserInput {

    private static Scanner input = new Scanner(System.in);

    public static int getInt(String message) {

        int userInput = 0;
        boolean isWrongInput = true;

        while (isWrongInput) {
            clear();
            System.out.println(message);

            try {
                userInput = input.nextInt();
                isWrongInput = false;
            }

            catch (InputMismatchException e) {
                System.out.println("Type right option!");
            }
        }

        return userInput;
    }

    public static float getFloat(String message) {
        clear();
        float userInput = -1;

        System.out.println(message + ": ");

        try {
            userInput = input.nextFloat();
        }

        catch (InputMismatchException e) {
            System.out.println("Type a number!");
            getFloat(message);
        }

        return userInput;
    }

    public static String getString(String message) {
        clear();
        System.out.println(message + ": ");
        return input.nextLine();

    }

    public static boolean isAccept(String message) {
        clear();
        boolean unvalidInput = true;
        boolean result = false;

        while (unvalidInput) {
            System.out.format("%s?(y/n)");
            String userInput = input.nextLine();

            if (userInput.equals("y")){
                result = true;
                unvalidInput = false;
            }
            else if(userInput.equals("n")) {
                unvalidInput = false;
            }
            else {
                System.out.println("Type y or n");
            }
        }
        return result;
    }

    private static void clear() {
        input = new Scanner(System.in);
    }
}