package com.revature.onlineretailapp.menus;
import com.revature.onlineretailapp.dao.CustomerRepoDB;
import com.revature.onlineretailapp.service.CustomerService;

import java.util.Scanner;

// Applies for customers with existing accounts
public class CustomerLogin implements IMenu {

    Scanner scanner = new Scanner(System.in);
    //CustomerService service = new CustomerService(new CustomerRepoDB());

    @Override
    public void start(){

        String userInput;

        do{
            System.out.println("Welcome Back");


            //you need to be able to access objects that have been created
            // then you need to see if they match the user input
            //Once that is succesfull take them to customerMenu




        } while(true); // for now; we might not need to use a do while loop.



    }
}
