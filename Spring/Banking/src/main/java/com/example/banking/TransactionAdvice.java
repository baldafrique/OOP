package com.example.banking;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransactionAdvice {
	@Before("execution(* com.example.banking.IBanking.*(..))")
	public void before() {
		System.out.println("Database is connected");
	}
	
	@After("execution(* com.example.banking.IBanking.*(..))")
	public void after() {
		System.out.println("Database is disconnected");
	}
}
