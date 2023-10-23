package org.example.dao;

import org.example.entities.InsuranceK;
import org.example.filters.InsuranceBFilter;

public class InsuranceBDao extends InsuranceDao<InsuranceK, InsuranceBFilter> {

    public InsuranceBDao() {
        super(InsuranceK.class);
    }
}
