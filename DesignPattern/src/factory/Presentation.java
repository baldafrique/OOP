package factory;

import polymorphism.BusinessLogic;

public abstract class Presentation {
	BusinessLogic businessLogic;
	
	public Presentation() {
		
	}
	
	public Presentation(BusinessLogic businessLogic) {
		this.businessLogic = businessLogic;
	}
	
	public BusinessLogic getBusinessLogic() {
		return businessLogic;
	}
	
	public abstract void doPresentation();

	public void setBusinessLogic(BusinessLogic businessLogic) {
		this.businessLogic = businessLogic;
	}
}
