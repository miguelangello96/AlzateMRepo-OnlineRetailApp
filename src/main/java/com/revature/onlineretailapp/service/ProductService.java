package com.revature.onlineretailapp.service;

import com.revature.onlineretailapp.dao.IProductRepo;
import com.revature.onlineretailapp.models.Product;

import java.util.ArrayList;

public class ProductService {

    ValidationService inputValidation = new ValidationService();
    IProductRepo repo;

    public ProductService(IProductRepo repo){
        this.repo = repo;
    }

    public void createNewProduct(){
        boolean success = false;

        do{
            String name = inputValidation.getValidStringInput("Enter name of product: ");
            double price = inputValidation.getValidDouble("Enter price of product: ");
            String description = inputValidation.getValidStringInput("Enter brief product description: ");

            try {

                Product newProduct = new Product(name, price, description);

                repo.addProduct(newProduct);
                success = true;


            }catch(Exception e) {
                System.out.println("Failed to add product");

            }


        }while(!success);

    }

    public void deleteProduct(){
        boolean success = false;

        do{
            //String name = inputValidation.getValidStringInput("Enter name of product: ");
            //double price = inputValidation.getValidDouble("Enter price of product: ");
            int productId = inputValidation.getValidInt("Enter Product ID of item you want to delete:  ");

            try {

                //Product productToDelete = new Product(name, price, description);

                repo.removeProduct(productId);
                success = true;


            }catch(Exception e) {
                System.out.println("Failed to delete product");

            }


        }while(!success);

    }

    public void getProducts() {
        ArrayList<ArrayList<String>> retrievedProduct = repo.getAllProducts();
        for (ArrayList<String> product : retrievedProduct){
            System.out.println(product);
        }
    }
}
