package strategy;

public class SUV extends Car {
	public SUV() {
		super(new BrakeWithABS());
	}
}
