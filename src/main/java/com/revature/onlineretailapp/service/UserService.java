package com.revature.onlineretailapp.service;

import com.revature.onlineretailapp.dao.IUserRepo;
import com.revature.onlineretailapp.models.Admin;
import com.revature.onlineretailapp.models.Customer;

import java.util.List;

public class UserService {

    ValidationService inputValidation = new ValidationService();
    IUserRepo repo;

    public UserService(IUserRepo repo){
        this.repo = repo;
    }

    public void createNewCustomer() {
        boolean success = false;
        do {

            String firstName = inputValidation.getValidStringInput("Enter first name: ");
            String lastName = inputValidation.getValidStringInput("Enter last name: ");
            String email = inputValidation.getValidStringInput("Enter email address: ");
            String password = inputValidation.getValidStringInput("Enter a password: ");

            try {
                //uses constructor to create new customer object
                Customer newCustomer = new Customer(firstName, lastName, email, password);

                /*Thread addCustomerThread = new Thread(() -> {
                    repo.addCustomer(newCustomer);
                    //System.out.println("Account created!");

                });
                addCustomerThread.start();
                 */
                //Moved add customer outside of the thread
                repo.addCustomer(newCustomer);
                success = true;
            } catch (Exception e){
                //For now just have this plain message
                System.out.println("Failed to create account");
            }


        }while(!success); //

    }

    public void createNewAdmin(){
        boolean success = false;
        do {

            String firstName = inputValidation.getValidStringInput("Enter first name: ");
            String lastName = inputValidation.getValidStringInput("Enter last name: ");
            String email = inputValidation.getValidStringInput("Enter email address: ");
            String password = inputValidation.getValidStringInput("Enter a password: ");

            try {
                //uses constructor to create new customer object
                Admin newAdmin = new Admin(firstName, lastName, email, password);

                /*Thread addCustomerThread = new Thread(() -> {
                    repo.addCustomer(newCustomer);
                    //System.out.println("Account created!");

                });
                addCustomerThread.start();
                 */
                //Moved add customer outside of the thread
                repo.addAdmin(newAdmin);
                success = true;
            } catch (Exception e){
                //For now just have this plain message
                System.out.println("Failed to create account");
            }


        }while(!success); //

    }

    // Consider making this method be in the admin class
    public void getCustomers() {
        List<Customer> retrievedCustomers = repo.getAllCustomers();
        for (Customer customer : retrievedCustomers){
            System.out.println(customer);
        }
    }


}
