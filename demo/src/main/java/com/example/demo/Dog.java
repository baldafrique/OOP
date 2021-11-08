package com.example.demo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("dog")
public class Dog extends Pet implements Runnable {

	@Override
	public void speak() {
		System.out.println("Bow wow.");
	}

	@Override
	public void run() {
		System.out.println("The dog is running.");
	}
	
	public void eat() {
		super.eat();
		super.eat();
	}

}
