package com.example.petstore;

import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long>{    // Repository Pattern Interface
	
}
