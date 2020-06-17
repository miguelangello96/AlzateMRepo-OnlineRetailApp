package com.revature.onlineretailapp.dao;

import com.revature.onlineretailapp.models.Customer;
import com.revature.onlineretailapp.models.Admin;

import com.revature.onlineretailapp.models.PaymentInfo;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserRepoDBTest extends TestCase {

    @Mock
    ResultSet resultSet;
    @Mock
    UserRepoDB userRepoDB;
    @Mock
    IUserRepo iUserRepo;
    @Mock
    PreparedStatement preparedStatement;

    private Customer customer;
    private PaymentInfo paymentInfo;
    private Admin admin;

    @Before public void initialize() throws Exception {

        iUserRepo = userRepoDB;
        customer = new Customer("Jim","Halpert", "jim@dunder.com", "pranks");

        when(preparedStatement.executeQuery()).thenReturn(resultSet);
        when(resultSet.getString(1)).thenReturn(customer.getFirstName());
        when(resultSet.getString(2)).thenReturn(customer.getLastName());
        when(resultSet.getString(3)).thenReturn(customer.getEmail());
        when(resultSet.getString(4)).thenReturn(customer.getPassword());
        when(resultSet.next()).thenReturn(true);

        iUserRepo = userRepoDB;
        paymentInfo = new PaymentInfo("9823756284766213", "825");

        when(preparedStatement.executeQuery()).thenReturn(resultSet);
        when(resultSet.getString(1)).thenReturn(paymentInfo.getCardNum());
        when(resultSet.getString(2)).thenReturn(paymentInfo.getSecurityCode());
        when(resultSet.next()).thenReturn(true);

        iUserRepo = userRepoDB;
        admin = new Admin("Michael","Jordan", "champion@bulls.com", "basketball");

        when(preparedStatement.executeQuery()).thenReturn(resultSet);
        when(resultSet.getString(1)).thenReturn(admin.getFirstName());
        when(resultSet.getString(2)).thenReturn(admin.getLastName());
        when(resultSet.getString(3)).thenReturn(admin.getEmail());
        when(resultSet.getString(4)).thenReturn(admin.getPassword());
        when(resultSet.next()).thenReturn(true);

    }

    @Test
    public void testAddCustomer(){
        iUserRepo.addCustomer(customer, paymentInfo);
    }

    @Test
    public void testAddAdmin(){
        iUserRepo.addAdmin(admin);
    }


}
