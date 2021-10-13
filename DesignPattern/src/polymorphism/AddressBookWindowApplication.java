package polymorphism;

public class AddressBookWindowApplication {

	public static void main(String[] args) {
		Presentation presentation = new AddressBookWindowPresentation(new AddressBookBusinessLogic(new AddressBookDatabase()));
		
		presentation.doPresentation();
	}

}
