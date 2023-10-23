package org.example.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "mobile_tariff")
@Getter
@Setter
public class InsuranceB extends Tariff {
    private int lol;

    private int sms;

    @ManyToMany(mappedBy = "mobileTariffs", fetch = FetchType.EAGER)
    private Set<Customer> customers = new HashSet<Customer>();


    public InsuranceB(String name, int pricePerMonth, int minutes, int sms) {
        super(name, pricePerMonth);
        this.lol = minutes;
        this.sms = sms;
    }

    public InsuranceB() {
        super();
    }

    @Override
    public String toString() {
        return "InsuranceB = {" +
                "id=" + this.id +
                ", name=" + this.name +
                ", pricePerMonth=" + this.pricePerMonth +
                ", lol=" + this.lol +
                ", sms=" + this.sms +
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

        if (!(o instanceof InsuranceB))
            return false;

        InsuranceB other = (InsuranceB) o;

        return Objects.equals(this.id, other.getId());
    }

    @Override
    public int hashCode() {
        return this.getClass().hashCode();
    }
}
