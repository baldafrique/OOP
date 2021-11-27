package com.example.petstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/* followings are httpie scripts to test scenario
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


//	@RequestMapping(method = RequestMethod.GET, path="/")
//	public String listPets(){
//		final StringBuffer result = new StringBuffer();
//
//		result.append("<h1> PET STORE </h1>");
//
//		pets.values().forEach(pet -> {result.append("<li>"+pet);});
//
//		result.append("<p> 총 페이지뷰:"+ HomeAdvice.getPageView());
//		return result.toString();
//	}
//
//	@RequestMapping(method = RequestMethod.GET, path="{petId}")
//	public String showPet(@PathVariable(value = "petId") String petId){
//		StringBuffer result = new StringBuffer();
//		Pet thePet = pets.get(petId);
//
//		if(thePet==null) return null;
//
//		result.append("{");
//		result.append("<h1>"+petId+"</h1>");
//		result.append("'petId': '" + petId + "', ");
//
//		result.append("<br>에너지: " + thePet.getEnergy());
//		result.append("'energy': " + thePet.getEnergy());
//		result.append("}");
//
//		result.append("<li> <a href='"+petId+"/feed'>먹이주기</a>");
//		result.append("<li> <a href='"+petId+"/sleep'>재우기</a>");
//		result.append("<li> <a href='"+petId+"/cart'>입양하기</a>");
//
//		if(thePet instanceof Groomable)
//			result.append("<li> <a href='"+petId+"/groom'>그루밍하기</a>");
//
//		return result.toString();
//	}

	@Autowired
	PetRepository petRepository;


//	@RequestMapping(method = RequestMethod.GET, path="{petId}/cart")
//	public String addToCart(@PathVariable(value = "petId") String petId) throws Exception{
//		//StringBuffer result = new StringBuffer();
//		Pet thePet = pets.get(petId);
//		thePet = thePet.getClass().newInstance();
//		thePet.setName(names[(int) Math.round(Math.random() * names.length)]);

		//// GOOD ////
//		cart.save(thePet);  // Separation of Concerns. Dependency Inversion Principle. //Ubiqutous Language.

		/////  BAD ///////

		// why? - following code is technically specific, infra-related code. must be moved to Repository implementation and hidden.

		// Connection connection = H2FileDatabaseExample.getDBConnection();
        // Statement stmt = null;
		// StringBuffer petsInDB = new StringBuffer();
        // try {
        //     connection.setAutoCommit(false);
        //     stmt = connection.createStatement();
        //     //stmt.execute("CREATE TABLE PET(name varchar(255))");
        //     stmt.execute("INSERT INTO PET(name) VALUES('"+ thePet.getClass().getSimpleName()+"')");

        //     ResultSet rs = stmt.executeQuery("select * from PET");
        //     while (rs.next()) {
        //         petsInDB.append("<li> "+rs.getString("name"));
        //     }
        //     stmt.close();
        //     connection.commit();
        // } catch (SQLException e) {
        //     System.out.println("Exception Message " + e.getLocalizedMessage());
        // } catch (Exception e) {
        //     e.printStackTrace();
        // } finally {
        //     connection.close();
        // }

//		Iterable<Pet> result = cart.findAll();
//		StringBuffer buffer = new StringBuffer();
//		result.forEach(pet -> {
//			buffer.append("<li>" + pet.getId() + " " + pet.getClass().getSimpleName() + " " + pet.getName());
//		});
//
//
//		return "성공적으로 입양했습니다<br>" + buffer.toString();
//	}

	@RequestMapping(method = RequestMethod.PUT, path="pets/{petId}/feed")
	public String feedPet(@PathVariable(value = "petId") Long petId){
//		StringBuffer result = 
		new StringBuffer();
		Pet thePet = petRepository.findById(petId).get();

		thePet.eat();
		
		petRepository.save(thePet);
		return "맛있는 거 먹였습니다.";
	}


	@RequestMapping(method = RequestMethod.PUT, path="pets/{petId}/groom")
	public String groomPet(@PathVariable(value = "petId") Long petId){
		Pet thePet = petRepository.findById(petId).get();

		if(thePet instanceof Groomable){
			String message = ((Groomable)thePet).grooming();
			petRepository.save(thePet);
			return message;
			
		}
		

		return "그루밍이 불가능한 Pet 입니다";
	}
	
	@RequestMapping(method = RequestMethod.PUT, path="cats/{petId}/groom")
	public String groomCat(@PathVariable(value = "petId") Long petId){
		return groomPet(petId);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path="cats/{petId}/feed")
	public String feedCat(@PathVariable(value = "petId") Long petId){
		return feedPet(petId);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path="dogs/{petId}/feed")
	public String feedDog(@PathVariable(value = "petId") Long petId){
		return feedPet(petId);
	}
	
	
}
