package com.revature.onlineretailapp.dao;

import com.revature.onlineretailapp.models.Product;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductRepoDBTest extends TestCase{

    @Mock
    ResultSet resultSet;
    @Mock
    ProductRepoDB productRepoDB;
    @Mock
    IProductRepo iProductRepo;
    @Mock
    PreparedStatement preparedStatement;

    private Product product;

    @Before public void initialize() throws Exception {

        iProductRepo = productRepoDB;
        product = new Product("Computer", 10000, "This is the Bat Computer");

        when(preparedStatement.executeQuery()).thenReturn(resultSet);
        when(resultSet.getString(1)).thenReturn(product.getName());
        when(resultSet.getDouble(2)).thenReturn(product.getPrice());
        when(resultSet.getString(3)).thenReturn(product.getDescription());
        when(resultSet.next()).thenReturn(true);

    }

    @Test
    public void testAddProduct() {
        iProductRepo.addProduct(product);

    }

    @Test
    public void testGetAllProducts(){


    }
}
