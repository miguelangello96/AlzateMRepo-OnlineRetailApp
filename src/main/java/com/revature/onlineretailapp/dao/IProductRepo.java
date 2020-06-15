package com.revature.onlineretailapp.dao;

import com.revature.onlineretailapp.models.Product;

import java.util.ArrayList;

public interface IProductRepo {

    public Product addProduct(Product product);
    public void removeProduct(int id);
    public ArrayList<ArrayList<String>> getAllProducts();


}
