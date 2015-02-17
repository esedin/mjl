package com.yard42.l.java.leak;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Producer Consumer Problem Code...");
	   new ClassPathXmlApplicationContext("problem-context.xml");
		System.out.println("Main Ending...");
	}
}
