package application;

public class Presentation {
	BusinessLogic businessLogic;
	
	public Presentation(BusinessLogic businessLogic) {
		this.businessLogic = businessLogic;
	}
	
	public BusinessLogic getBusinessLogic() {
		return businessLogic;
	}
	
	public void doPresentation() {
		// leave it empty
	}
}
