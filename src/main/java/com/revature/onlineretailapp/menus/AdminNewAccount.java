package com.revature.onlineretailapp.menus;

import com.revature.onlineretailapp.dao.UserRepoDB;
import com.revature.onlineretailapp.service.ConnectionService;
import com.revature.onlineretailapp.service.UserService;

public class AdminNewAccount implements IMenu {

    private ConnectionService connectionService = new ConnectionService();
    private UserService service = new UserService(new UserRepoDB(connectionService));

    @Override
    public void start() {

        System.out.println("Create a new Admin");
        System.out.println("Enter information to create a new account.");
        System.out.println("");

        service.createNewAdmin();



    }
}
