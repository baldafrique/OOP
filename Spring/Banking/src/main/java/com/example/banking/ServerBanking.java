package com.example.banking;

import java.io.IOException;
import java.net.UnknownHostException;

import org.springframework.stereotype.Service;

@Service
public class ServerBanking implements IBanking {
	
	public ServerBanking() {
		System.out.println("Bank is created");
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
