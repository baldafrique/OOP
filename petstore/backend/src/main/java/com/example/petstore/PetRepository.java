package com.example.petstore;

import org.springframework.data.repository.CrudRepository;

import com.example.petstore.domain.Pet;

public interface PetRepository extends CrudRepository<Pet, Long>{ 
	
}
