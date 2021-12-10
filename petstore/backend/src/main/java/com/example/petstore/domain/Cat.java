package com.example.petstore.domain;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("cat")
public class Cat extends Pet implements Groomable, Serializable, Runnable{

	public Cat() { // set the type to a cat
		setType("Cat");
	}
	
    @Override
    public void speak() {
        if(getEnergy() < 5){ // energy가 5 미만인 경우            
            System.out.println("I'm hungry");
        } else {
        	System.out.println("Hi");	
        }
    }

    @Override
    public String grooming() {
    	// grooming() increase appearance by 1
    	setAppearance(getAppearance() + 1); 
        return "야옹. 행복하다 집사야.";
    }

    @Override
    public void run() {
        System.out.println("I'm running!!!");
    }

    
}
