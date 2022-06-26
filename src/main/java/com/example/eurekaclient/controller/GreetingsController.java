package com.example.eurekaclient.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.instrument.util.StringUtils;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class GreetingsController {

	// Greetings map.
	static Map<String, String> greetings;
	// Initialize the greetings map at the application start-up.
	static {
		greetings = new HashMap<>();
		greetings.put("fr", "BONJOUR");
		greetings.put("es", "HOLA");
		greetings.put("de", "GUTENTAG");
		greetings.put("it", "CIAO");
		greetings.put("en", "GOOD MORNING");
		greetings.put("jp", "おはようございます");
	}

	@GetMapping(value = { "/welcome/{localeId}", "/welcome" })
	public String getGreetings(@PathVariable(name = "localeId", required = false) String localeId) {
		String langCode = StringUtils.isEmpty(localeId) ? "en" : localeId;
		log.info("Fetching greetings type for locale id= {}", langCode);
		return greetings.entrySet().stream().filter(code -> langCode.equalsIgnoreCase(code.getKey()))
				.map(Map.Entry::getValue).collect(Collectors.joining());
	}

}
