package application;

public class AddressBookPresentation extends Presentation {

	public AddressBookPresentation(BusinessLogic businessLogic) {
		super(businessLogic);
	}
	
	public void doPresentation() {
		getBusinessLogic().doBusinessLogic();
	}
	
}
