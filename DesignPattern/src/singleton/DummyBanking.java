package singleton;

import java.io.IOException;
import java.net.UnknownHostException;

public class DummyBanking implements IBanking {

	@Override
	public Integer deposit(Integer money) {
		return -1;
	}

	@Override
	public Integer withdraw(Integer money) throws UnknownHostException, IOException {
		return null;
	}

}
