package com.trial.java8;

import java.util.ArrayList;
import java.util.List;

public class Java8Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GreetingService greetService=message->
		System.out.println("Hello "+message);
		greetService.sayMessage("Aashu");
		
		Runnable run=()->
		System.out.println("Run method written");
		run.Run();
		
		Java8Tester2 trial=()->
		System.out.println("Trial method running");
		trial.trialMethod();
		
		List<String> list=new ArrayList();
		list.add("Aashu");
		list.add("Jony");
		list.add("Yashu");
		list.add("Anshul");
		list.add("Anu");
		list.forEach(System.out::println);
	}
interface GreetingService{
	void sayMessage(String message);
}
interface Runnable{
	void Run();
}
interface Java8Tester2{
	void trialMethod();
}
}
