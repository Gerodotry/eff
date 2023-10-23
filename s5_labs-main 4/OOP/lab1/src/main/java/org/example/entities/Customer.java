package org.example.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue
    private long id;

    private String name;

    @CreationTimestamp
    @Column(name = "created_on")
    private Instant createdOn;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="customer_insuranceK",
            joinColumns=  @JoinColumn(name="customer_id", referencedColumnName="id"),
            inverseJoinColumns= @JoinColumn(name="insuranceK_id", referencedColumnName="id"))
    private Set<InsuranceK> riffs = new HashSet<InsuranceK>();

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "customer_insuranceA",
            joinColumns = @JoinColumn(name="customer_id", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name="insuranceA_id", referencedColumnName="id"))
    private Set<InsuranceA> insuranceAs = new HashSet<InsuranceA>();

    public Customer() {

    }

    public Customer(String name) {
        this.name = name;
    }

    public void addInsuranceB(InsuranceK insuranceK) {
        if (insuranceK != null) {
            this.riffs.add(insuranceK);
            insuranceK.addCustomer(this);
        }
    }

    public void removeInsuranceB(InsuranceK insuranceK) {
        if (insuranceK != null) {
            this.riffs.remove(insuranceK);
            insuranceK.removeCustomer(this);
        }
    }

    public void addInsuranceA(InsuranceA insuranceA) {
        if (insuranceA != null) {
            this.insuranceAs.add(insuranceA);
            insuranceA.addCustomer(this);
        }
    }

    public void removeInsuranceA(InsuranceA insuranceA) {
        if (insuranceA != null) {
            this.insuranceAs.remove(insuranceA);
            insuranceA.removeCustomer(this);
        }
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + this.id +
                ", name='" + this.name + '\'' +
                ", createdOn=" + this.createdOn +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Customer))
            return false;

        Customer other = (Customer) o;

        return Objects.equals(this.id, other.getId());
    }

    @Override
    public int hashCode() {
        return this.getClass().hashCode();
    }
}