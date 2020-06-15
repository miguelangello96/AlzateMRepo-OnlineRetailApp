package com.revature.onlineretailapp.dao;

import com.revature.onlineretailapp.models.Product;
import com.revature.onlineretailapp.service.ConnectionService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductRepoDB implements IProductRepo {


    private ConnectionService connectionService = ConnectionService.getInstance();

    public ProductRepoDB(ConnectionService connectionService){

        this.connectionService = connectionService;
    }


    @Override
    public Product addProduct(Product product) {

        try{

            PreparedStatement addProductStatement = connectionService.getConnection().prepareStatement("INSERT INTO products " +
                    "(name, price, description) VALUES(?, ?, ?)");

            addProductStatement.setString(1, product.getName());
            addProductStatement.setDouble(2, product.getPrice());
            addProductStatement.setString(3, product.getDescription());

            addProductStatement.executeUpdate();


            return product;

        }catch (SQLException e){

            System.out.println("Exception " + e.getMessage());
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void removeProduct(int id) {

        try {

            PreparedStatement removeStatement =
                    connectionService.getConnection().prepareStatement("DELETE FROM products WHERE product_id = ?");

            removeStatement.setInt(1, id);


            removeStatement.executeUpdate();
            System.out.println("Success");
            //System.out.println("Removed: "+ product.toString());

            //return true;

        } catch (Exception e) {

            e.getMessage();

        }

        //return false;

    }

    @Override
    public ArrayList<ArrayList<String>> getAllProducts() {
        ArrayList<String> inner;
        ArrayList<ArrayList<String>> outer = new ArrayList<>();
        try {


            PreparedStatement selectAllStatement = connectionService.getConnection().prepareStatement("SELECT * FROM products");

            ResultSet rs = selectAllStatement.executeQuery();

            while(rs.next()){
                inner = new ArrayList<>();
                for(int i = 1; i <= 4; i++)
                {
                    inner.add(rs.getString(i));
                }
                outer.add(inner);
            }

            return outer;


        }catch (Exception e){
            e.getMessage();
        }

        return null;
    }
}
