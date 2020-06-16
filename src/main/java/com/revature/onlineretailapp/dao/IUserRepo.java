package com.revature.onlineretailapp.dao;
import java.util.ArrayList;

import com.revature.onlineretailapp.models.Customer;
import com.revature.onlineretailapp.models.Admin;
import com.revature.onlineretailapp.models.PaymentInfo;

public interface IUserRepo {

    public Customer addCustomer(Customer customer, PaymentInfo paymentInfo);
    public Admin addAdmin(Admin admin);

    public void viewPaymentInfo(int customerID);
    public ArrayList<ArrayList<String>> getUserPaymentInfo();
    public ArrayList<ArrayList<String>> getAllCustomers();
}
