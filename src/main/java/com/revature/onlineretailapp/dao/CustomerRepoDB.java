package com.revature.onlineretailapp.dao;
import com.revature.onlineretailapp.models.Customer;
import com.revature.onlineretailapp.service.ConnectionService;

import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.util.List;

public class CustomerRepoDB implements ICustomerRepo {

    //private Connection connection;
    ConnectionService connectionService;


    //This is what connects to the server now using the ConnectionService Class
    public CustomerRepoDB(ConnectionService connectionService) {

        this.connectionService = connectionService;
    }

    @Override
    public Customer addCustomer(Customer customer){

        try {

            PreparedStatement customerStatement = connectionService.getConnection().prepareStatement("INSERT INTO customer " +
                    "(firstName, lastName, email, password) VALUES (?, ?, ?, ?)");

            customerStatement.setString(1, customer.getFirstName());
            customerStatement.setString(2, customer.getLastName());
            customerStatement.setString(3, customer.getEmail());
            customerStatement.setString(4, customer.getPassword());

            customerStatement.executeUpdate();

            // for each loop is possible for adding inventory do this in admin
            // In video its minute 23 to add items into array variable

            return customer;


        } catch (SQLException e) {

            System.out.println("Exception " + e.getMessage());
            e.printStackTrace();

        }
        return null;
    }

    @Override
    public List<Customer> getAllCustomers() {

        return null;
    }

}
