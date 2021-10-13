package application;

public class AddressBookBusinessLogic extends BusinessLogic {

	public AddressBookBusinessLogic(Database database) {
		super(database);
	}

	public AddressBookBusinessLogic() {
		// TODO Auto-generated constructor stub
	}

	public void doBusinessLogic() {
		getDatabase().save();
		getDatabase().load();
	}
}
