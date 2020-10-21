package io.digrajkarmeetprojects.coronavirustrackingapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CoronavirusTrackingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoronavirusTrackingAppApplication.class, args);
	}

}
