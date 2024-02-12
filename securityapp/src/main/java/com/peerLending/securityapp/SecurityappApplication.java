package com.peerLending.securityapp;

import com.peerLending.securityapp.user.model.SecurityUsers;
import com.peerLending.securityapp.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SecurityappApplication implements CommandLineRunner {
  @Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(SecurityappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	userRepository.save(new SecurityUsers("John","Geneva123"));
	userRepository.save(new SecurityUsers("Mark","SpaceJam150"));
	userRepository.save(new SecurityUsers("James","Jenxpin"));
	}
}
