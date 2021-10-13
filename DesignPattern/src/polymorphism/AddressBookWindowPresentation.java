package polymorphism;

import java.awt.Frame;
import java.awt.Label;

public class AddressBookWindowPresentation extends AddressBookPresentation {

	public AddressBookWindowPresentation(BusinessLogic businessLogic) {
		super(businessLogic);
	}

	public void doPresentation() {
		System.out.println("Displayed on the window screen ...");
		getBusinessLogic().doBusinessLogic();
	}
}
