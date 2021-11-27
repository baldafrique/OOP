package com.example.petstore;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("dog")
public class Dog extends Pet implements Runnable {
	
	public Dog() {
		setType("Dog");
	}
	
    @Override
    public void speak() {
        System.out.println("멍멍");
    }

    @Override
    public void run() {
        System.out.println(" Dog Run!!!");
        
    }

    @Override
    public void eat() {
        
        super.eat();
        super.eat();

    }

    
    
    
}
