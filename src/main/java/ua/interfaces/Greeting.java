package ua.interfaces;

import java.time.LocalTime;

public interface Greeting {

	public String greet(LocalTime time);
	
	public String greet();
}
