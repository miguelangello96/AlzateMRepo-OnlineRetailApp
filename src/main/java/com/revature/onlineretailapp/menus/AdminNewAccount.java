package com.revature.onlineretailapp.menus;

import com.revature.onlineretailapp.dao.UserRepoDB;
import com.revature.onlineretailapp.service.ConnectionService;
import com.revature.onlineretailapp.service.UserService;

import java.sql.SQLException;

public class AdminNewAccount implements IMenu {

    private ConnectionService connectionService = new ConnectionService().getInstance();
    private UserService service = new UserService(new UserRepoDB(connectionService));

    @Override
    public void start() {

        System.out.println("Create a new Admin");
        System.out.println("Enter information to create a new account.");
        System.out.println("");

        try {

            service.createNewAdmin();

        }catch(Exception e){
            e.getMessage();

        } finally {

            try {

                connectionService.finalize();
            }catch(Exception e){

                e.getMessage();

            }
        }


    }
}
