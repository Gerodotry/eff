package org.example.dao;

import org.example.entities.InsuranceA;
import org.example.filters.InsuranceAFilter;

public class InsuranceADao extends InsuranceDao<InsuranceA, InsuranceAFilter> {

    public InsuranceADao() {
        super(InsuranceA.class);
    }
}
