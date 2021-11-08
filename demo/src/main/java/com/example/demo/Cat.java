package com.example.demo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("cat")
public class Cat extends Pet implements Runnable, Groomable {

	@Override
	public void run() {
		System.out.println("The cat is running.");
	}

	@Override
	public void speak() {
		if (getEnergy() < 5) {
			System.out.println("I'm hungry.");
		}
		else {
			System.out.println("Meow.");
		}
	}

	@Override
	public String grooming() {
		return "I'm happy.";
	}
	
}
