package com.revature.onlineretailapp.menus;
import com.revature.onlineretailapp.dao.CustomerRepoDB;
import com.revature.onlineretailapp.service.*;


// Applies for customers with existing accounts
public class CustomerLogin implements IMenu {

    private String emailPrompt = "Enter Email: ";
    private String passwordPrompt = "Enter Password: ";
    //Consider putting these in the Customer class

    private String customerEmailStatement = "SELECT * FROM customer WHERE email =";
    private String customerPasswordStatement = "SELECT * FROM customer WHERE password =";
    //String adminTableStatement = "SELECT * FROM admin WHERE email =";

    private CredentialVerification customerVerification = new CredentialVerification();
    private CustomerMenu customerMenu = new CustomerMenu();

    @Override
    public void start(){

        boolean email;
        boolean password;

        System.out.println("Welcome Back - Customer Login");
        System.out.println("");

        email = customerVerification.loginVerification(emailPrompt, customerEmailStatement);
        password = customerVerification.loginVerification(passwordPrompt, customerPasswordStatement);


        //Takes them to Customer Menu if both correct
        if(email && password)
            customerMenu.start();

    }
}
