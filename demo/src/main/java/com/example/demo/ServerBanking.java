package com.example.demo;

public class ServerBanking implements IBanking {

	int balance = 0;
	
	@Override
	public Integer deposit(Integer money) {
		balance += money;
		return balance;
	}

	@Override
	public Integer withdraw(Integer money) {
		balance -= money;
		return balance;
	}

}
