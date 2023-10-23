package org.example.dao;

import org.example.entities.Customer;
import org.example.entities.InsuranceA;
import org.example.entities.InsuranceK;
import org.example.sessions.TransactionManager;

public class CustomerDao extends AbstractDao<Customer> {

    public CustomerDao() {
        super(Customer.class);
    }

    public void addInsuranceB(Customer customer, InsuranceK insuranceK) {
        customer.addInsuranceB(insuranceK);
        TransactionManager.commitTransaction(session ->
                session.merge(customer));
    }

    public void removeInsuranceB(Customer customer, InsuranceK insuranceK) {
        customer.removeInsuranceB(insuranceK);
        TransactionManager.commitTransaction(session ->
                session.merge(customer));
    }

    public void addInsuranceA(Customer customer, InsuranceA insuranceA) {
        customer.addInsuranceA(insuranceA);
        TransactionManager.commitTransaction(session ->
                session.merge(customer));
    }

    public void removeInsuranceA(Customer customer, InsuranceA insuranceA) {
        customer.removeInsuranceA(insuranceA);
        TransactionManager.commitTransaction(session ->
                session.merge(customer));
    }

}
