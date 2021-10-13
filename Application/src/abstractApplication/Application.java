package abstractApplication;

import application.BusinessLogic;
import application.Database;

public abstract class Application {
	public void run() {
		Presentation presentation = getPresentation();
		BusinessLogic businessLogic = getBusinessLogic();
//		Database database = getDatabase();
		
		// in the case of simulation, there is no data left.
		Database database;
		boolean simulationMode = true;
		
		if (simulationMode) {
			database = new SimulationDatabase();
		} else {
			database = getDatabase();
		}
		
		businessLogic.setDatabase(database);
		presentation.setBusinessLogic(businessLogic);
		
		presentation.doPresentation();
	}
	
	abstract Presentation getPresentation();
	abstract BusinessLogic getBusinessLogic();
	abstract Database getDatabase();
	
}
