package com.revature.onlineretailapp.service;

import com.revature.onlineretailapp.models.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

//This class is used to Verify login information
public class CredentialVerification {

    ValidationService inputValidation = new ValidationService();
    ConnectionService connectionService = new ConnectionService().getInstance();

    //private String customerEmailStatement = "SELECT * FROM customer WHERE email =";




    //No-args Constructor
    public CredentialVerification() {

    }

    public boolean emailVerification(String prompt, String sqlTableStatement) {

        try {

            //System.out.println("Welcome Back - Customer Login");
            String userInput = inputValidation.getValidStringInput(prompt);
            PreparedStatement inputCheck =
                    connectionService.getConnection().prepareStatement
                            (sqlTableStatement + "'"+ userInput + "'");
            //Consider making statement variables for both the admin and the customer
            //Simply pass those in and now you only need one method

            ResultSet resultSet = inputCheck.executeQuery();


            //Checks to see if result has appropriate email
            if (resultSet.next()) {

                //String email = resultSet.getString("email");


                //int id = resultSet.getInt(1);
                //String firstName = resultSet.getString(2);
                //String lastName = resultSet.getString(3);


                //System.out.println("Records Match!"); //For testing purposes

                //success = true;
                return true;

            } else {
                System.out.println("Fail");
            }

        } catch (SQLException e) {
            System.out.println("Input does not match");

            e.getMessage();
        }

        return false;
    }


    public boolean passwordVerification(String prompt, String sqlTableStatement) {

        try {

            //System.out.println("Welcome Back - Customer Login");
            String userInput = inputValidation.getValidStringInput(prompt);
            PreparedStatement inputCheck =
                    connectionService.getConnection().prepareStatement
                            (sqlTableStatement + "'"+ userInput + "'");
            //Consider making statement variables for both the admin and the customer
            //Simply pass those in and now you only need one method

            ResultSet resultSet = inputCheck.executeQuery();


            //Checks to see if result has appropriate email
            if (resultSet.next()) {

                String email = resultSet.getString("email");


                int id = resultSet.getInt(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);


                System.out.println("Records Match!"); //For testing purposes
                System.out.println("ID: " + id);
                System.out.println("First Name: " + firstName);
                System.out.println("Last Name: " + lastName);

                //success = true;
                return true;

            } else {
                System.out.println("Fail");
            }

        } catch (SQLException e) {
            System.out.println("Input does not match");

            e.getMessage();
        }

        return false;
    }

    public String getEmail(String userInput){
        //String result = " ";

        try {

            //String userInput = inputValidation.getValidStringInput(prompt);
            PreparedStatement inputCheck =
                    connectionService.getConnection().prepareStatement
                            ("SELECT * FROM customer WHERE email =" +"''" + userInput + "''");
            //Consider making statement variables for both the admin and the customer
            //Simply pass those in and now you only need one method

            ResultSet resultSet = inputCheck.executeQuery();


            //Checks to see if result has appropriate email
            if (resultSet.next()) {

                int customer_id = resultSet.getInt("customer_id");
                String email = resultSet.getString("email");

                //getCustomerID(email);

                return email;

                //System.out.println(email);

            } else {
                System.out.println("Fail");
            }

        } catch (SQLException e) {
            System.out.println("Input does not match");

            e.getMessage();
        }

        return null;
    }

    public int getCustomerID(String userInput){
        int result;

        try {

            //String userInput = inputValidation.getValidStringInput(prompt);
            PreparedStatement inputCheck =
                    connectionService.getConnection().prepareStatement
                            ("SELECT * FROM customer WHERE email =" +"''" + userInput + "''");
            //Consider making statement variables for both the admin and the customer
            //Simply pass those in and now you only need one method

            ResultSet resultSet = inputCheck.executeQuery();


            //Checks to see if result has appropriate email
            if (resultSet.next()) {

                int customer_id = resultSet.getInt("customer_id");
                //String email = resultSet.getString("email");

                return  customer_id;


            } else {
                System.out.println("Fail");
            }

        } catch (SQLException e) {

            e.getMessage();
        }

        return 0; // nothing
    }



}