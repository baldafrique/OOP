package com.example.petstore.shop;

import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PostPersist;

import com.example.petstore.domain.Pet;

@Entity
public class CartItem {
	
	@PostPersist
	public void afterSave() {
		getPets().get(0).setEnergy(10);
	}
	
	@Id @GeneratedValue
	Long id;
	
	@ManyToOne
	Customer customer;
	
	@OneToMany
	List<Pet> pets;
	
	@Embedded
	Payment payment;
	
	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
