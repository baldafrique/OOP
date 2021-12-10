package com.example.petstore.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("dog") // entity 저장 시 구분 컬럼에 입력할 값 지정
public class Dog extends Pet implements Runnable {
	
	public Dog() { // set the type to a dog
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
    	// eat() increase energy by 1
        setEnergy(getEnergy() + 1);
    }

    public void sleep() {
    	super.sleep(); // increase appearance by 2
    	setAppearance(getAppearance() + 1); // increase appearance by 1
    }
    
    
}
