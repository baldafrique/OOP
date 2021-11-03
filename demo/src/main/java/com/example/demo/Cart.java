package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Cart implements ICart{
	
	List<Pet> pets = new ArrayList<Pet>();
	

	@Override
	public Pet add(Pet pet) {
		pets.add(pet);
		return pet;
	}

	@Override
	public Pet remove(Pet pet) {
		pets.remove(pet);
		return pet;
	}
	
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("list : <br>");
		pets.stream().forEach(pet -> buffer.append("<li>" + pet.toString()));
		
		return buffer.toString();
	}
	
}
