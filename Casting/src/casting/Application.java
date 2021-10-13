package casting;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		String species = scanner.next();
		Animal animal = new Animal();
		
//		if (species.equals("Dog")) {
//			animal = new Dog();
//		} else if (species.equals("Cat")) {
//			animal = new Cat();
//		}
		
		animal =  (Animal) Class.forName("casting." + species).newInstance();
		
		animal.bark();
		
	}

}
