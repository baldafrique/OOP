package observer;

import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(5);
		list.add(4);
		list.add(3);
		list.add(2);
		list.add(1);
		
		for (int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		list.forEach((x) -> System.out.println(x));
		list.stream()
			.filter(x -> x > 3)
			.map(x -> x * x)
			.sorted()
			.forEach(System.out::println);
			
		
		Animal animal = new Dog();
		
//		anonymous class
//		animal.addListener(new Listener() {
//			@Override
//			public void energyChanged(int energy) {
//				if (energy > 10) {
//					System.out.println("Don't feed too much!");
//				}
//			}
//		});
		
//		lambda expression
		animal.addListener((energy) -> {
			if (energy > 10) {
				System.out.println("Don't feed too much!");
			}
		});
		animal.addListener(new FeedListener());
		
		for (int i=0; i<11; i++) {
			if (i % 3 == 0) {
				animal.speak();
			}
			animal.eat();
		}
		
	}

}
