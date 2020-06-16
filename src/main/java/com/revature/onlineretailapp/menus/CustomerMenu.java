package com.revature.onlineretailapp.menus;

import com.revature.onlineretailapp.dao.IProductRepo;
import com.revature.onlineretailapp.dao.IUserRepo;
import com.revature.onlineretailapp.service.ProductService;
import com.revature.onlineretailapp.service.UserService;

import java.util.Scanner;

public class CustomerMenu implements IMenu {

    IProductRepo productRepo;
    IUserRepo userRepo;

    private Scanner scanner = new Scanner(System.in);
    CustomerPurchaseMenu purchaseMenu = new CustomerPurchaseMenu();



    @Override
    public void start(){

        ProductService productService = null;

        try{

            productService = new ProductService(productRepo);

        }catch(Exception e){

            e.getMessage();
        }

        UserService userService = null;

        try{

            userService = new UserService(userRepo);

        }catch(Exception e){

            e.getMessage();
        }

        String userInput;

        System.out.println("Login Success - You are in Customer Menu");

        do {

            System.out.println("");
            System.out.println("What would you like to do?");
            System.out.println("[0] Look at Items currently in Stock");
            System.out.println("[1] View Payment Information");
            System.out.println("[2] View Transaction History");
            System.out.println("[3] Log Out - Return to Main Menu");


            userInput = scanner.nextLine();


            switch (userInput) {
                case "0":

                    //Displays All Current products
                    productService.getProducts();
                    //call customerMenu
                    purchaseMenu.start();

                    break;

                case "1":

                    userService.viewPaymentInfo();



                    break;
                case "2":

                    //Just Display Transaction history if they have it, if not tell them - Service class to display it
                    //When they have purchased items add them to table with relation to customer id
                    System.out.println("Transaction History");

                    break;
                case "3":

                    System.out.println("Logging Out");

                    break;


                default:
                    System.out.println("Invalid input please try again!");


            }


        } while (!userInput.equals("3")); // for now I will change when I know how many options this will have


    }
}
