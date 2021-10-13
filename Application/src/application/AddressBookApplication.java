package application;

public class AddressBookApplication {

	public static void main(String[] args) {
		Presentation presentation = new AddressBookPresentation(
				new AddressBookBusinessLogic(new AddressBookDatabase()));

		presentation.doPresentation();
	}

}
