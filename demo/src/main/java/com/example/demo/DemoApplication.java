package com.example.demo;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController("pets")
@EnableAspectJAutoProxy
public class DemoApplication {

	static HashMap<String, Pet> pets = new HashMap<>();
	
	public static void main(String[] args) {
		pets.put(Dog.class.getSimpleName().toLowerCase(), new Dog());
		pets.put(Cat.class.getSimpleName().toLowerCase(), new Cat());
		
		SpringApplication.run(DemoApplication.class, args);
	}
	
	
	@RequestMapping(method = RequestMethod.GET, path="/")
	public String listPets() {
		final StringBuffer result = new StringBuffer();
		
		result.append("<h1>Pet Store</h1>");
		
		pets.values().forEach(pet -> {result.append("<li>" + pet);});
		
		result.append("<p>Hits : " + HomeAdvice.getHits() + "</p>");
		return result.toString();
	}
	
	@RequestMapping(method = RequestMethod.GET, path="{petId}")
	public String showPet(@PathVariable(value = "petId") String petId) {
		StringBuffer result = new StringBuffer();
		Pet thePet = pets.get(petId);
		
		if (thePet == null) {
			return null;
		}
		
		result.append("<h1>" + petId + "</h1>");
		result.append("<br>");
		result.append("<p>Energy : " + thePet.getEnergy() + "</p>");
		result.append("<li><a href='" + petId + "/feed'>Feed</a>");
		result.append("<li><a href='" + petId + "/sleep'>Sleep</a>");
		result.append("<li><a href='" + petId + "/adopt'>Adopt</a>");
		
		if (thePet instanceof Groomable) {
			result.append("<li><a href='" + petId + "/groom'>Groom</a>");
		}
		
		return result.toString();
	}
	
//	@Autowired
//	Cart cart;
//	
//	@RequestMapping(method = RequestMethod.GET, path="{petId}/cart")
//	public String addToCart(@PathVariable(value = "petId") String petId) {
//		Pet thePet = pets.get(petId);
//		cart.add(thePet);
//		return "Adopt success<br>." + cart; 
//	}
	
	@RequestMapping(method = RequestMethod.GET, path="{petId}/feed")
	public String feed(@PathVariable(value = "petId") String petId) {
		StringBuffer result = new StringBuffer();
		Pet thePet = pets.get(petId);
		
		thePet.eat();
		return "Feeding success.";
	}
	
	@RequestMapping(method = RequestMethod.GET, path="{petId}/sleep")
	public String sleep(@PathVariable(value = "petId") String petId) {
		StringBuffer result = new StringBuffer();
		Pet thePet = pets.get(petId);
		
		thePet.sleep();
		String state = "The " + petId + " is sleeping.";
		return state;
	}
	
	@RequestMapping(method = RequestMethod.GET, path="{petId}/groom")
	public String groom(@PathVariable(value = "petId") String petId) {
		Pet thePet = pets.get(petId);
		
		if (thePet instanceof Groomable) {
			return (((Groomable) thePet).grooming());
		}
		else {
			return "Failed grooming.";
		}
		
	}
}
