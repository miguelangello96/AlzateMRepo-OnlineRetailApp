package com.revature.onlineretailapp.menus;

import com.revature.onlineretailapp.dao.CustomerRepoFile;
import com.revature.onlineretailapp.service.CustomerService;

import java.sql.SQLOutput;
import java.util.Scanner;

public class CustomerNewAccount implements IMenu {

    CustomerService service = new CustomerService(new CustomerRepoFile());

    @Override
    public void start() {

        System.out.println("Welcome new Customer!");
        System.out.println("Enter your information to create a new account.");
        System.out.println("");

        service.createNewCustomer();

    }
}
