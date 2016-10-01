package ua.main;

import java.time.LocalTime;

import ua.implementations.GreetingImpl;
import ua.interfaces.Greeting;

public class Main {

	public static void main(String[] args) {
		Greeting greeting = new GreetingImpl();
		System.out.println(greeting.greet(LocalTime.of(0, 0)));
	}

}