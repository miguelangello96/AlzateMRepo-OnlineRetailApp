package com.revature.onlineretailapp.service;

import com.revature.onlineretailapp.dao.ICustomerRepo;
import com.revature.onlineretailapp.models.Customer;

import java.util.List;

public class CustomerService {

    ValidationService inputValidation = new ValidationService();
    ICustomerRepo repo;

    public CustomerService(ICustomerRepo repo){
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

                Thread addCustomerThread = new Thread(() -> {
                    repo.addCustomer(newCustomer);
                    //System.out.println("Account created!");

                });
                addCustomerThread.start();
                success = true;
            } catch (Exception e){
                //For now just have this plain message
                System.out.println("Failed to create account");
            }


        }while(!success); //

    }

    //This method will check to see if userinput matches an existing customer object
    public void LoginVerification() {


    }
    // Consider making this method be in the admin class
    public void getCustomers() {
        List<Customer> retrievedCustomers = repo.getAllCustomers();
        for (Customer customer : retrievedCustomers){
            System.out.println(customer);
        }
    }
}
