package com.example.banking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableAspectJAutoProxy
public class BankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingApplication.class, args);
	}
	
	@RequestMapping(method = RequestMethod.GET, path="/")
	public String Hello() {
		return "Hello, world!";
	}
	
	@RequestMapping(method = RequestMethod.GET, path="/balances/{account}")
	public String balance(@PathVariable("account") String account) {
		return "Balance for account " + account;
	}
	
	@Autowired
	ServerBanking serverBanking;
	
	@RequestMapping(method = RequestMethod.GET, path="/deposit/{money}")
	public String balance(@PathVariable("money") Integer money) {
		return "Balance is " + serverBanking.deposit(money);
	}
}
