package ua.tests;
import static org.junit.Assert.assertEquals;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import ua.implementations.GreetingImpl;

@RunWith(value = Parameterized.class)
public class GreetingTest {

	@Parameter(value = 0)
  public LocalTime numberA;

  @Parameter(value = 1)
  public String expected;
  
  @Parameter(value = 2)
  public String lang;
  
  @Parameter(value = 3)
  public String country;

  @Parameters()
  public static Collection<Object[]> data() {
      return Arrays.asList(new Object[][]{
              {LocalTime.of(0, 0), "Good night, World!", "en", "US"},
              {LocalTime.of(6, 1), "Good morning, World!", "en", "US"},
              {LocalTime.of(9, 1), "Good day, World!", "en", "US"},
              {LocalTime.of(19, 1), "Good evening, World!", "en", "US"},
              {LocalTime.of(23, 1), "Good night, World!", "en", "US"},
              {LocalTime.of(0, 0), "Доброї ночі, Світ!", "uk", "UA"},
              {LocalTime.of(6, 1), "Добрий ранок, Світ!", "uk", "UA"},
              {LocalTime.of(9, 1), "Добрий день, Світ!", "uk", "UA"},
              {LocalTime.of(19, 1), "Добрий вечір, Світ!", "uk", "UA"},
              {LocalTime.of(23, 1), "Доброї ночі, Світ!", "uk", "UA"},
              {LocalTime.of(0, 0), "Доброй ночи, Мир!", "ru", "RU"},
              {LocalTime.of(6, 1), "Доброе утро, Мир!", "ru", "RU"},
              {LocalTime.of(9, 1), "Добрый день, Мир!", "ru", "RU"},
              {LocalTime.of(19, 1), "Добрый вечер, Мир!", "ru", "RU"},
              {LocalTime.of(23, 1), "Доброй ночи, Мир!", "ru", "RU"}
      });
  }
	
	@Test
	public void greetTest() {
		String greet = new GreetingImpl(new Locale(lang, country)).greet(numberA);
		assertEquals(expected, greet);
	}
	
	@Test
	public void greetTest2() {
		Locale locale = new Locale("en", "US");
		Locale.setDefault(locale);
		String greet = new GreetingImpl().greet(LocalTime.of(0, 0));
		assertEquals("Good night, World!", greet);
	}
	
	
}
