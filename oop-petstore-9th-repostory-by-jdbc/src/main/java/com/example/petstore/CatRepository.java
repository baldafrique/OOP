package com.example.petstore;

import org.springframework.data.repository.CrudRepository;

public interface CatRepository extends CrudRepository<Cat, Long>{    // Repository Pattern Interface
	
}
