package com.revature.onlineretailapp.menus;

import com.revature.onlineretailapp.dao.UserRepoDB;
import com.revature.onlineretailapp.service.ConnectionService;
import com.revature.onlineretailapp.service.UserService;
import com.revature.onlineretailapp.dao.IUserRepo;


public class AdminNewAccount implements IMenu {

    //private ConnectionService connectionService = new ConnectionService().getInstance();
    IUserRepo repo;


    @Override
    public void start() {

        UserService userService = null;

        try{

            userService = new UserService(repo);

        }catch(Exception e){

            e.getMessage();
        }

        System.out.println("Create a new Admin");
        System.out.println("Enter information to create a new account.");
        System.out.println("");

        try {

            userService.createNewAdmin();

        }catch(Exception e){
            e.getMessage();

        }


    }
}
