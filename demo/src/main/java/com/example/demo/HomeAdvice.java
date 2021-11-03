package com.example.demo;

import org.aspectj.lang.annotation.After;

public class HomeAdvice {
	static int hits = 0;
	
	public static int getHits() {
		return hits;
	}
	
	@After("execution(* com.example.demo.DemoApplication.*(..))")
	public void after() {
		++hits;
	}
}
