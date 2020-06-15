package com.revature.onlineretailapp.menus;

import com.revature.onlineretailapp.dao.ProductRepoDB;
import com.revature.onlineretailapp.dao.UserRepoDB;
import com.revature.onlineretailapp.service.ConnectionService;
import com.revature.onlineretailapp.service.ProductService;
import com.revature.onlineretailapp.service.UserService;

import java.util.Scanner;

public class AdminMenu implements IMenu {

    private Scanner scanner = new Scanner(System.in);
    private AdminNewAccount adminNewAccount = new AdminNewAccount();

    private ConnectionService connectionService = new ConnectionService().getInstance();
    private ProductService service = new ProductService(new ProductRepoDB(connectionService));


    @Override
    public void start(){

        String userInput;
        //String UpdateProduct;

        System.out.println("");

        do {
            System.out.println("Admin Menu");
            System.out.println("");

            System.out.println("[0] Create Admin Account");
            System.out.println("[1] Add new Product to Inventory");
            System.out.println("[2] Delete Product from Inventory");
            System.out.println("[3] Update Promo Codes (Add/Delete"); // this one might change
            System.out.println("[4] Return to Main Menu");

            userInput = scanner.nextLine();


            switch (userInput) {
                case "0":
                    //Takes me to new admin
                    adminNewAccount.start();

                    break;

                case "1":
                    //Update inventory Menu - For ADD list attributes and price
                    //  - For Delete Drop row from Table

                    service.createNewProduct();

                    break;
                case "2":

                    System.out.println("Current products!");
                    service.getProducts();
                    service.deleteProduct();

                    System.out.println("Current products");
                    service.getProducts();

                    break;

                case "3":
                    //Update Promos Menu - For ADD list price deduction
                    //  - For Delete Drop row from Table
                    break;

                case "4":

                    System.out.println("Logging Out");

                    break;

                default:
                    System.out.println("Invalid input please try again!");



            }

        }while(!userInput.equals("4"));
    }
}
