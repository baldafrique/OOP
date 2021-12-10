package com.example.petstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.petstore.domain.Groomable;
import com.example.petstore.domain.Pet;

/* 
followings are httpie scripts to test scenario
http localhost:8080/dogs name='멍멍이' energy=2
http PUT "http://localhost:8080/pets/1/feed"
http "http://localhost:8080/pets/1"
http localhost:8080/cats name="야옹이" energy=2
http "http://localhost:8080/pets/2"
http PUT "http://localhost:8080/pets/2/feed"
http "http://localhost:8080/pets/2"
http PUT "http://localhost:8080/pets/1/groom"
http PUT "http://localhost:8080/pets/2/groom"
*/

@SpringBootApplication
@RestController
@EnableAspectJAutoProxy
public class PetApplication {

//	static HashMap<String, Pet> pets = new HashMap<String, Pet>();
	String[] names = {"젤리", "대박이", "감자", "사랑", "자몽이", "꼬맹이", "몽이", "모리", "하리", "해피", "하트", "콩", "태양"};

	public static void main(String[] args) {
//		pets.put(Dog.class.getSimpleName().toLowerCase(), new Dog());
//		pets.put(Cat.class.getSimpleName().toLowerCase(), new Cat());

		SpringApplication.run(PetApplication.class, args);
	}


	@Autowired // 의존 객체의 타입에 해당하는 bean을 찾아 주입
	PetRepository petRepository;

	// path pets/{petId}/feed와 feedPet()을 mapping하여 feedPet() 실행
	@RequestMapping(method = RequestMethod.PUT, path="pets/{petId}/feed")
	public String feedPet(@PathVariable(value = "petId") Long petId){
		Pet thePet = petRepository.findById(petId).get();
		thePet.eat();
		petRepository.save(thePet); // feed를 한 뒤 petRepository에 저장 
		return "맛있는 거 먹였습니다.";
	}

	// path pets/{petId}/groom와 groomPet()을 mapping하여 groomPet() 실행
	@RequestMapping(method = RequestMethod.PUT, path="pets/{petId}/groom")
	public String groomPet(@PathVariable(value = "petId") Long petId){
		Pet thePet = petRepository.findById(petId).get();

		// petId로 받은 instance가 interface groomable의 instance인 경우(Cat)
		if(thePet instanceof Groomable){
			String message = ((Groomable)thePet).grooming();
			petRepository.save(thePet);
			return message;
		}
		
		// petId로 받은 instance가 interface groomable의 instance가 아닌 경우(Dog)
		return "그루밍이 불가능한 Pet 입니다";
	}
	
	// path cats/{petId}/groom와 groomCat()을 mapping하여 groomCat() 실행
	@RequestMapping(method = RequestMethod.PUT, path="cats/{petId}/groom")
	public String groomCat(@PathVariable(value = "petId") Long petId){
		return groomPet(petId);
	}
	
	// path cats/{petId}/feed와 feedCat()을 mapping하여 feedCat() 실행
	@RequestMapping(method = RequestMethod.PUT, path="cats/{petId}/feed")
	public String feedCat(@PathVariable(value = "petId") Long petId){
		return feedPet(petId);
	}
	
	// path dogs/{petId}/feed와 feedDog()을 mapping하여 feedDog() 실행
	@RequestMapping(method = RequestMethod.PUT, path="dogs/{petId}/feed")
	public String feedDog(@PathVariable(value = "petId") Long petId){
		return feedPet(petId);
	}
	
	
}
