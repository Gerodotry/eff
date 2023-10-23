package org.example.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "InsuranceK")
@Getter
@Setter
public class InsuranceK extends Insurance {
    private int minutes;

    private int coverage;

    @ManyToMany(mappedBy = "riffs", fetch = FetchType.EAGER)
    private Set<Customer> customers = new HashSet<Customer>();


    public InsuranceK(String name, int pricePerMonth, int minutes, int coverage) {
        super(name, pricePerMonth);
        this.minutes = minutes;
        this.coverage = coverage;
    }

    public InsuranceK() {
        super();
    }

    @Override
    public String toString() {
        return "InsuranceK = {" +
                "id=" + this.id +
                ", name=" + this.name +
                ", pricePerMonth=" + this.pricePerMonth +
                ", minutes=" + this.minutes +
                ", coverage=" + this.coverage +
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

        if (!(o instanceof InsuranceK))
            return false;

        InsuranceK other = (InsuranceK) o;

        return Objects.equals(this.id, other.getId());
    }

    @Override
    public int hashCode() {
        return this.getClass().hashCode();
    }
}
