package com.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServerLoginAppApplication {

	/*@Autowired
	private UserService userService;*/

	public static void main(String[] args) {
		SpringApplication.run(ServerLoginAppApplication.class, args);
	}

	/*@Override
	public void run(String... args) throws Exception {
		UserDto user = new UserDto("Dao", "Dang", "daodang", "123456", 16, 1000);
		userService.save(user);
	}*/

}
