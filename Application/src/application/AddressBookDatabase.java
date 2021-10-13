package application;

public class AddressBookDatabase extends Database {
	public void save() {
		System.out.println("Insert into addressBook value");
	}
	
	public void load() {
		System.out.println("Select value from addressBook");
	}
}
