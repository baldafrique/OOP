package singleton;

import java.io.IOException;
import java.net.UnknownHostException;

public class TransactionProxyBanking implements IBanking {
	
	IBanking realBanking;
	
	public TransactionProxyBanking(IBanking realBanking) {
		this.realBanking = realBanking;
	}

	@Override
	public Integer deposit(Integer money) throws UnknownHostException, IOException {
		System.out.println("Database is connected");
		int balance = realBanking.deposit(money);
		System.out.println("Database is disconnected");
		
		return balance;
	}

	@Override
	public Integer withdraw(Integer money) throws UnknownHostException, IOException {
		System.out.println("Database is connected");
		int balance = realBanking.withdraw(money);
		
		if (balance < 0) {
			System.out.println("Database is rolledbacked");
		}
		System.out.println("Database is disconnected");
		
		return balance;
	}
	
}
