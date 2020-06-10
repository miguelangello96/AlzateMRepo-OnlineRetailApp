package com.revature;

import com.revature.onlineretailapp.menus.IMenu;
import com.revature.onlineretailapp.menus.RetailMenuFactory;
import com.revature.onlineretailapp.menus.StartingMenu;
import com.revature.onlineretailapp.models.User;

import java.util.Scanner;

public class App {
    public static void main(String [] args){


        StartingMenu mainMenu = new StartingMenu();
        mainMenu.start();
        /*
        Scanner scan = new Scanner(System.in);

        //Created User object with admin userType
        User masterAdmin = new User("001", "masterAdmin@email.com", "adminPassword", "Admin", true);

        //Created RetailMenuFactory object
        RetailMenuFactory retailMenu = new RetailMenuFactory();
        System.out.println(masterAdmin.getUserType());

        IMenu menu = retailMenu.getMenu(masterAdmin.getUserType());
        menu.start();

         */

    }
}
