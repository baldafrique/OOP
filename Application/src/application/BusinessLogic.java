package application;

public class BusinessLogic {
	Database database;
	
	public BusinessLogic(Database database) {
		this.database = database;
	}
	
	public Database getDatabase() {
		return database;
	}
	
	public void doBusinessLogic() {
		// leave it empty
	}
}
