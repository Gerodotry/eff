package org.example.services;

import org.example.dao.InsuranceBDao;
import org.example.entities.InsuranceK;
import org.example.filters.InsuranceBFilter;

import java.util.List;

public class InsuranceBService {
    private final InsuranceBDao insuranceBDao = new InsuranceBDao();

    public InsuranceBService() {

    }

    public InsuranceK findById(long id) {
        return this.insuranceBDao.findById(id);
    }

    public List<InsuranceK> findAll() {
        return this.insuranceBDao.findAll();
    }

    public List<InsuranceK> sortByPrice(){
        return this.insuranceBDao.sortAllByParameter("pricePerMonth");
    }

    public Long countAll() {
        return this.insuranceBDao.countAll();
    }


    public void saveInsuranceB(InsuranceK insuranceK) {
        this.insuranceBDao.save(insuranceK);
    }

    public void updateInsuranceB(InsuranceK insuranceK) {
        this.insuranceBDao.update(insuranceK);
    }

    public void deleteInsuranceB(InsuranceK insuranceK) {
        this.insuranceBDao.delete(insuranceK);
    }

    public List<InsuranceK> findByFilter(InsuranceBFilter filter) {
        return this.insuranceBDao.findAllByFilter(filter);
    }
}
