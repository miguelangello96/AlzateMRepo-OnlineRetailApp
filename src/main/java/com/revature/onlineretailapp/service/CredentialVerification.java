package com.revature.onlineretailapp.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

//This class is used to Verify login information
public class CredentialVerification {

    ValidationService inputValidation = new ValidationService();
    ConnectionService connectionService = new ConnectionService().getInstance();




    //No-args Constructor
    public CredentialVerification() {

    }

    public boolean loginVerification(String prompt, String sqlTableStatement) {

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

                System.out.println("Records Match!"); //For testing purposes
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

}