package com.example.petstore;

import org.springframework.data.repository.CrudRepository;

import com.example.petstore.domain.Dog;

public interface DogRepository extends CrudRepository<Dog, Long>{ 
	
}
