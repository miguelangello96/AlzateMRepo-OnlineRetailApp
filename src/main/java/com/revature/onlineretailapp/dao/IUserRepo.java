package com.revature.onlineretailapp.dao;
import java.util.List;
import com.revature.onlineretailapp.models.Customer;
import com.revature.onlineretailapp.models.Admin;

public interface IUserRepo {

    public Customer addCustomer(Customer customer);
    public Admin addAdmin(Admin admin);
    public List<Customer> getAllCustomers();
}
