package com.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.learning.model.Alien;
import com.learning.repo.AlienRepo;

@SpringBootApplication
public class SpringJdbcProjectApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJdbcProjectApplication.class, args);
		
		Alien alien = context.getBean(Alien.class);
		alien.setId(0);
		alien.setName("Rahul");
		alien.setTech("JS");
		
		AlienRepo repo = context.getBean(AlienRepo.class);
		repo.save(alien);
		System.out.println(repo.returnAll());
	}

}
