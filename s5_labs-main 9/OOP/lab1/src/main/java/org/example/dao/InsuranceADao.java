package org.example.dao;

import org.example.entities.HomeTariff;
import org.example.filters.HomeTariffFilter;

public class InsuranceADao extends TariffDao<HomeTariff, HomeTariffFilter> {

    public InsuranceADao() {
        super(HomeTariff.class);
    }
}
