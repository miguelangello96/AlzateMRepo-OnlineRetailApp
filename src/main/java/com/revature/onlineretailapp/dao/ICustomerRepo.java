package com.revature.onlineretailapp.dao;
import java.util.List;
import com.revature.onlineretailapp.models.Customer;

public interface ICustomerRepo {

    public Customer addCustomer(Customer customer);
    public List<Customer> getAllCustomers();

}
