package application;

public class AddressBookApplication {

	public static void main(String[] args) {
		AddressBookPresentation presentation = new AddressBookPresentation(
				new AddressBookBusinessLogic(new AddressBookDatabase()));
		
		presentation.doPresentation();
	}

}
