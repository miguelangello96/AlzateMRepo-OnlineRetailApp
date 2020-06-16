package com.revature.onlineretailapp.menus;
import com.revature.onlineretailapp.dao.IProductRepo;
import com.revature.onlineretailapp.service.*;
import java.util.Scanner;


public class CustomerLogin implements IMenu {

    private String emailPrompt = "Enter Email: ";
    private String passwordPrompt = "Enter Password: ";
    private String customerEmailStatement = "SELECT * FROM customer WHERE email =";
    private String customerPasswordStatement = "SELECT * FROM customer WHERE password =";

    private CredentialVerification customerVerification = new CredentialVerification();
    private CustomerMenu customerMenu = new CustomerMenu();



    @Override
    public void start() {

        boolean email;
        boolean password;


        //String userInput;
        //String buyInput;

        System.out.println("Welcome Back - Customer Login");
        System.out.println("");

        email = customerVerification.emailVerification(emailPrompt, customerEmailStatement);
        password = customerVerification.passwordVerification(passwordPrompt, customerPasswordStatement);


        //Takes them to Customer Menu if both correct
        if (email && password) {

            customerMenu.start();
        }



    }
}
