package com.example.petstore;

import org.springframework.data.repository.CrudRepository;

import com.example.petstore.domain.CartItem;

public interface CartItemRepository extends CrudRepository<CartItem, Long>{ 

}
