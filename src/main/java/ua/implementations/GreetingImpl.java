package ua.implementations;

import java.time.DateTimeException;
import java.time.LocalTime;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import ua.interfaces.Greeting;

public class GreetingImpl implements Greeting {

	private final ResourceBundle bundle;
	private static final Logger LOGGER = Logger.getLogger(GreetingImpl.class);

	private static final Map<LocalTime, String> DAY_PARTS;

	static {
		DAY_PARTS = new LinkedHashMap<>();

		DAY_PARTS.put(LocalTime.of(6, 0), "night");
		DAY_PARTS.put(LocalTime.of(9, 0), "morning");
		DAY_PARTS.put(LocalTime.of(19, 0), "day");
		DAY_PARTS.put(LocalTime.of(23, 0), "evening");
		DAY_PARTS.put(LocalTime.of(23, 59), "night");
	}

	public GreetingImpl(Locale locale) {
		if (locale != null) {
			LOGGER.info("Creating instance GreetingImpl with locale: " + locale);
			bundle = ResourceBundle.getBundle("localization/Locale", locale);
		} else {
			LOGGER.info("Creating default instance GreetingImpl");
			bundle = ResourceBundle.getBundle("localization/Locale");
		}
	}

	public GreetingImpl() {
		this(null);
	}

	public String greet(LocalTime time) {
		LOGGER.info("Input parameters: time = " + time);
		String partOfDay = getPartOfDay(time);
		String greet = bundle.getString(partOfDay);
		LOGGER.info("Return value: " + greet);
		return greet;
	}

	private String getPartOfDay(LocalTime localTime) {
		LOGGER.info("Input parameters: localTime = " + localTime);
		for (LocalTime time : DAY_PARTS.keySet()) {
			if (localTime.compareTo(time) <= 0) {
				String dayPart = DAY_PARTS.get(time);
				LOGGER.info("Return value: " + dayPart);
				return dayPart;
			}
		}

		LOGGER.error("DateTimeException: localTime is invalid - " + localTime);
		// Never happen
		throw new DateTimeException("Invalid Time: " + localTime);
	}

}
