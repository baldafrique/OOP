package com.example.banking;

import java.io.IOException;
import java.net.UnknownHostException;

public interface IBanking {
	Integer deposit(Integer money) throws UnknownHostException, IOException;
	Integer withdraw(Integer money) throws UnknownHostException, IOException;
}
