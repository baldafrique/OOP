package com.example.petstore;

import org.springframework.data.repository.CrudRepository;

import com.example.petstore.domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer, String>{ 

}
