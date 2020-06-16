package com.revature.onlineretailapp.dao;

import com.revature.onlineretailapp.models.Product;

import java.util.ArrayList;

public interface IProductRepo {

    public Product addProduct(Product product);
    public void removeProduct(int id);
    public void enterCart(int customerID);
    public void addLineItem(int cartID, int productID, int quantity);
    public void totalOrder();

    public ArrayList<ArrayList<String>> getAllProducts();


}
