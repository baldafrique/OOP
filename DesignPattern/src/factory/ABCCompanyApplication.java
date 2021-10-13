package factory;

import polymorphism.AddressBookBusinessLogic;
import polymorphism.BusinessLogic;
import polymorphism.Database;

public class ABCCompanyApplication  extends Application {

	@Override
	Presentation getPresentation() {
		return new WindowsPresentation();
	}

	@Override
	BusinessLogic getBusinessLogic() {
		return new AddressBookBusinessLogic();
	}

	@Override
	Database getDatabase() {
		return new MSSQLDatabase();
	}
	
	public static void main(String[] args) {
		ABCCompanyApplication ABCcompanyApplication = new ABCCompanyApplication();
		ABCcompanyApplication.run();
	}
	
}
