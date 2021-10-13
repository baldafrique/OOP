package application;

public class AddressBookBusinessLogic extends BusinessLogic {

	public AddressBookBusinessLogic(Database database) {
		super(database);
	}
	
	public void doBusinessLogic(Database database) {
		getDatabase().save();
		getDatabase().load();
	}
}
