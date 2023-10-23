package org.example.services;

import org.example.dao.InsuranceADao;
import org.example.entities.InsuranceA;
import org.example.filters.InsuranceAFilter;

import java.util.List;

public class InsuranceAService {
    private final InsuranceADao insuranceADao = new InsuranceADao();


    public InsuranceAService() {

    }

    public InsuranceA findById(long id) {
        return this.insuranceADao.findById(id);
    }

    public List<InsuranceA> findAll() {
        return this.insuranceADao.findAll();
    }

    public List<InsuranceA> sortByPrice(){
        return this.insuranceADao.sortAllByParameter("Risk");
    }

    public Long countAll() {
        return this.insuranceADao.countAll();
    }

    public void saveInsuranceA(InsuranceA insuranceA) {
        this.insuranceADao.save(insuranceA);
    }

    public void updateInsuranceA(InsuranceA insuranceA) {
        this.insuranceADao.update(insuranceA);
    }

    public void deleteInsuranceA(InsuranceA insuranceAFilter) {
        this.insuranceADao.delete(insuranceAFilter);
    }

    public List<InsuranceA> findByFilter(InsuranceAFilter insuranceAFilter) {
        return this.insuranceADao.findAllByFilter(insuranceAFilter);
    }
}
