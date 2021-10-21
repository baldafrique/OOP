package Lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Lambda {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for (int i=5; i>0; i--) {
			list.add(i);
		}

//		for (int i=0; i<list.size(); i++) {
//			System.out.println(list.get(i));
//		}
		
//		list.forEach(System.out::println);
		
		
		// Java 7 procedual expression
		List<Integer> filteredList = new ArrayList<>();
		
		for (int i=0; i<list.size(); i++) {
			if (list.get(i) > 3) {
				filteredList.add(list.get(i));
			}
		}
		
		List<Integer> squaredList = new ArrayList<>();
		for (int i=0; i<filteredList.size(); i++) {
			squaredList.add(filteredList.get(i) * filteredList.get(i));
		}
		
		squaredList.sort(new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				Integer i1 = (Integer) o1;
				Integer i2 = (Integer) o2;
				return i1 - i2;
			}
			
		});
		
		for (int i=0; i<squaredList.size(); i++) {
			System.out.println(squaredList.get(i));
		}
		
		// lambda expression
		list.stream()
			.filter(x -> x > 3)
			.map(x -> x * x)
			.sorted()
			.forEach(System.out::println);
		
		
	}

}
