package com.revature.onlineretailapp.menus;

public class RetailMenuFactory {
    public IMenu getMenu(String UserType) {
        switch(UserType.toLowerCase()){
            case "newUser":
                return new StartingMenu();
            case "admin":
                return new AdminMenu();
            case "customer":
                return new CustomerMenu();
            default:
                return null;
        }
    }
}
