package com.revature.onlineretailapp.dao;
import java.util.List;
import com.revature.onlineretailapp.models.Customer;
import com.revature.onlineretailapp.models.Admin;
import com.revature.onlineretailapp.models.PaymentInfo;

public interface IUserRepo {

    public Customer addCustomer(Customer customer);
    public Admin addAdmin(Admin admin);

    public PaymentInfo addPaymentInfo(PaymentInfo paymentInfo);
    public List<Customer> getAllCustomers();
}
