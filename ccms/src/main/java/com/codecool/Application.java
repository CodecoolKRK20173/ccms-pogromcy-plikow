package com.codecool;

import com.codecool.view.LogInMenu;
import com.codecool.view.Menu;

/**
 * Hello world!
 *
 */
public class Application
{
    public static void main( String[] args ) {

        Menu menu = new LogInMenu();
        menu.run();
    }
}
