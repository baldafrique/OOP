package polymorphism;

public class AddressBookBusinessLogic extends BusinessLogic {

	public AddressBookBusinessLogic(Database database) {
		super(database);
	}

	public AddressBookBusinessLogic() {
		
	}

	public void doBusinessLogic() {
		getDatabase().save();
		getDatabase().load();
	}
}
