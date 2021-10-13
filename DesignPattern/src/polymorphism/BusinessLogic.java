package polymorphism;

public class BusinessLogic {
	Database database;
	
	public BusinessLogic(Database database) {
		this.database = database;
	}
	
	public BusinessLogic() {
		
	}
	
	public Database getDatabase() {
		return database;
	}
	
	public void doBusinessLogic() {
		// leave it empty
	}

	public void setDatabase(Database database) {
		this.database = database;
	}

}
