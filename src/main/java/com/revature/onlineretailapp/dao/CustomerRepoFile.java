package com.revature.onlineretailapp.dao;

import com.revature.onlineretailapp.models.Customer;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepoFile implements ICustomerRepo {

    String filePath = "src/main/resources/Customer.txt";

    @Override
    public Customer addCustomer(Customer customer) {

        List<Customer> currentCustomers = this.getAllCustomers();
        try {
            ObjectOutputStream objectOutputStream =
                    new ObjectOutputStream(new FileOutputStream(filePath));
            currentCustomers.add(customer);
            objectOutputStream.writeObject(currentCustomers);
            objectOutputStream.close();
            System.out.println("Account created!");
            return customer;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Customer> getAllCustomers(){
        try {
            ObjectInputStream inputStream =
                    new ObjectInputStream(new FileInputStream(filePath));
            List<Customer> retrievedCustomers = (ArrayList<Customer>) inputStream.readObject();
            inputStream.close();
            return retrievedCustomers;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            //e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            //Just in class Hero class is not found
            e.printStackTrace();
        }

        return new ArrayList<Customer>();

    }
}