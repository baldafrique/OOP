package strategy;

public class CarExample {

	public static void main(String[] args) {
		Car sedanCar = new Sedan();
		sedanCar.applyBrake(); // This will invoke class "Brake"
		
		Car suvCar = new SUV();
		suvCar.applyBrake(); // This will invoke class "BrakeWithABS"
		
		// set brake behavior dynamically
		suvCar.setBrakeBehavior(new Brake());
		suvCar.applyBrake(); // This will invoke class "Brake"
	}

}
