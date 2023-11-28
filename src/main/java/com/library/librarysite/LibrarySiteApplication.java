//
package com.library.librarysite;

import com.library.librarysite.Data.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.stream.Stream;
import com.library.librarysite.Data.User;

@SpringBootApplication
public class LibrarySiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibrarySiteApplication.class, args);
	}

	/*@Bean
	CommandLineRunner init(UserRepository userRepository) {
		return args -> {
			Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
				User user = new User(name, name.toLowerCase() + "@domain.com");
				userRepository.save(user);
			});
			userRepository.findAll().forEach(System.out::println);
		};
	}*/

}
