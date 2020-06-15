package com.revature;

import com.revature.onlineretailapp.dao.UserRepoDB;
import com.revature.onlineretailapp.menus.IMenu;
import com.revature.onlineretailapp.menus.RetailMenuFactory;
import com.revature.onlineretailapp.menus.StartingMenu;
import com.revature.onlineretailapp.service.ConnectionService;


import java.util.Scanner;

public class App {
    public static void main(String [] args)  {

        ConnectionService connectionService = ConnectionService.getInstance();


        StartingMenu mainMenu = new StartingMenu();
        mainMenu.start();

        //To DO
        /*
            Create Admin functionality
            Add Items to product table
            Columns
                Include
                name varchar
                price INT
                description TEXT
                admin_id -> is Foreign key, treat like Generated value from customer and admin
         */
    }
}
