package com.example.petstore;

import org.springframework.data.repository.CrudRepository;

import com.example.petstore.domain.Cat;

public interface CatRepository extends CrudRepository<Cat, Long>{
	
}
