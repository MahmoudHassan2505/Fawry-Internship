package com.Spring.conferenceSpringboot;

import com.Spring.conferenceSpringboot.service.SpeakerService;
import com.Spring.conferenceSpringboot.service.SpeakerServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConferenceSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConferenceSpringbootApplication.class, args);
		SpeakerService service = new SpeakerServiceImpl();

		service.findAll().forEach(speaker -> System.out.println(speaker.getFirstname()));
	}

}
