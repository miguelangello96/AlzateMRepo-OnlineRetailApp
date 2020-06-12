package com.revature.onlineretailapp.menus;

import java.util.Scanner;

public class AdminMenu implements IMenu {

    private Scanner scanner = new Scanner(System.in);
    private AdminNewAccount adminNewAccount = new AdminNewAccount();


    @Override
    public void start(){

        String userInput;

        System.out.println("");

        do {
            System.out.println("Admin Menu");
            System.out.println("");

            System.out.println("[0] Create Admin Account");
            System.out.println("[1] Update Inventory (Add/Delete)");
            System.out.println("[2] Update Promo Codes (Add/Delete");
            System.out.println("[3] Return to Main Menu");

            userInput = scanner.nextLine();

            switch (userInput) {
                case "0":
                    //Takes me to new admin
                    adminNewAccount.start();

                    break;

                case "1":
                    //Update inventory Menu - For ADD list attributes and price
                                        //  - For Delete Drop row from Table


                    break;
                case "2":
                    //Update Promos Menu - For ADD list price deduction
                    //  - For Delete Drop row from Table


                    break;

                case "3":
                    System.out.println("Logging Out");
                    break;

                default:
                    System.out.println("Invalid input please try again!");



            }

        }while(!userInput.equals("3"));
    }
}
