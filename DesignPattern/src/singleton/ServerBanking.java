package singleton;

import java.io.IOException;
import java.net.UnknownHostException;

public class ServerBanking implements IBanking {
	
	static IBanking instance = new TransactionProxyBanking(new ServerBanking());
	
	public static IBanking getInstance() {
		return instance;
	}
	
	int balance = 0;
	
	@Override
	public Integer deposit(Integer money) {
		balance += money;
		return balance;
	}

	@Override
	public Integer withdraw(Integer money) throws UnknownHostException, IOException {
		balance -= money;
		return balance;
	}

}
