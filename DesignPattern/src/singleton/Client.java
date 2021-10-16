package singleton;

public class Client {

	public static void main(String[] args) throws Exception {
		
		IBanking banking = getBanking();
		System.out.println(banking.deposit(100));
		System.out.println(banking.withdraw(50));
	}

	private static IBanking getBanking() {
		return new BankingStub();
	}
	
}
