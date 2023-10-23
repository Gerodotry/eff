package org.example.services;

import org.example.dao.CustomerDao;
import org.example.entities.Customer;
import org.example.entities.InsuranceA;
import org.example.entities.InsuranceK;

import java.util.List;

public class CustomerService {
    private final CustomerDao customerDao = new CustomerDao();

    public CustomerService() {

    }

    public Customer findById(long id) {
        return this.customerDao.findById(id);
    }

    public List<Customer> findAll() {
        return this.customerDao.findAll();
    }

    public Long countAll() {
        return this.customerDao.countAll();
    }

    public void saveCustomer(Customer customer) {
        this.customerDao.save(customer);
    }

    public void updateCustomer(Customer customer) {
        this.customerDao.update(customer);
    }

    public void deleteCustomer(Customer customer) {
        this.customerDao.delete(customer);
    }

    public void addInsuranceB(Customer customer, InsuranceK insuranceK) {
        this.customerDao.addInsuranceB(customer, insuranceK);
    }

    public void removeInsuranceB(Customer customer, InsuranceK insuranceK) {
        this.customerDao.removeInsuranceB(customer, insuranceK);
    }

    public void addInsuranceB(Customer customer, InsuranceA insuranceA) {
        this.customerDao.addInsuranceA(customer, insuranceA);
    }

    public void removeInsuranceA(Customer customer, InsuranceA insuranceA) {
        this.customerDao.removeInsuranceA(customer, insuranceA);
    }
}
