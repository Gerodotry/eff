package org.example.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "InsuranceA")
@Getter
@Setter
public class InsuranceA extends Insurance {
    @Column(name = "data_allowance_mb")
    private int Risk;

    @Column(name = "speed_mbps")
    private int speedMbps;

    @ManyToMany(mappedBy = "insuranceAs", fetch = FetchType.EAGER)
    private Set<Customer> customers = new HashSet<Customer>();


    public InsuranceA(String name, int pricePerMonth, int Risk, int speedMbps) {
        super(name, pricePerMonth);
        this.Risk = Risk;
        this.speedMbps = speedMbps;
    }

    public InsuranceA() {

    }

    @Override
    public String toString() {
        return "InsuranceA{" +
                "id=" + this.id +
                ", pricePerMonth=" + this.pricePerMonth +
                ", Risk=" + this.Risk +
                ", speedMbps=" + this.speedMbps +
                '}';
    }

    public void addCustomer(Customer customer){
        this.customers.add(customer);
    }

    public void removeCustomer(Customer customer){
        this.customers.remove(customer);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof InsuranceA))
            return false;

        InsuranceA other = (InsuranceA) o;

        return Objects.equals(this.id, other.getId());
    }

    @Override
    public int hashCode() {
        return this.getClass().hashCode();
    }
}
