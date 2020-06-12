package com.revature.onlineretailapp.menus;

import java.util.Scanner;

public class CustomerMenu implements IMenu {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public void start(){

        String userInput;


        do {
            System.out.println("Login Success - You are in Customer Menu");
            System.out.println("");
            System.out.println("What would you like to do?");
            System.out.println("[0] Items Available for purchase");
            System.out.println("[1] Input/View payment information");
            System.out.println("[2] View Transaction History");
            System.out.println("[3] Log Out - Return to Main Menu");


            userInput = scanner.nextLine();

            switch (userInput) {
                case "0":

                    //Go to Display Inventory - Menu that displays items and has them ready for purchase
                    //Also displays promo codes
                    // if no payment info take them there
                    //If yes confirm purchase add promo codes if they want

                    break;

                case "1":

                    //Go to create payment information similar to create new account - just method in a class


                    break;
                case "2":

                    //Just Display Transaction history if they have it, if not tell them - Service class to display it


                    break;

                case "3":
                    System.out.println("Logging Out");

                    break;

                default:
                    System.out.println("Invalid input please try again!");



            }




        } while(!userInput.equals("3")); // for now I will change when I know how many options this will have
    }
}
