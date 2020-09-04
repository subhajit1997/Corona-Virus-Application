package com.tracker.coronaviruslivetracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.tracker.coronaviruslivetracker")
public class CoronavirusLiveTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoronavirusLiveTrackerApplication.class, args);
	}

}
