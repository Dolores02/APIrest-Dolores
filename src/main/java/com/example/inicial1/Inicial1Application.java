package com.example.inicial1;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.inicial1.entities.Domicilio;
import com.example.inicial1.entities.Persona;
import com.example.inicial1.repositories.PersonaRepository;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class Inicial1Application {

	private static final Logger logger = LoggerFactory.getLogger(Inicial1Application.class);

	@Autowired
	private PersonaRepository personaRepository;

	public static void main(String[] args) {
		SpringApplication.run(Inicial1Application.class, args);

		System.out.println("Funcionando....");
	}

	@Bean
	@Transactional
	CommandLineRunner init(PersonaRepository personaRepository){ return args -> {

		Persona person1 = Persona.builder()
				.apellido("Videla")
				.nombre("Dolores")
				.build();

		Domicilio domi1 = Domicilio.builder()
				.calle("A").numero(200)
				.build();

		person1.setDomicilio(domi1);

		personaRepository.save(person1); //con esto guardo

		//Creo otra persona

		Persona person2 = Persona.builder()
				.apellido("Derrache")
				.nombre("Carolina")
				.build();

		Domicilio domi2 = Domicilio.builder()
				.calle("B")
				.numero(100)
				.build();

		person2.setDomicilio(domi2);

		personaRepository.save(person2);

		List<Persona> recuperadas = personaRepository.findAll();
		System.out.println(recuperadas);

		logger.info("Detalles de la persona: {}",recuperadas);

		domi1.setCalle("C");
		personaRepository.save(person1);

	};
	}

}
