package com.java.spring.course.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.java.spring.course.model.User;
import com.java.spring.course.repository.UserRepository;

@Configuration // Indica que é uma classe de configuração
@Profile("test") // Indica que é uma classe de configuração específica para o perfil de teste
public class TestConfig implements CommandLineRunner { // CommandLineRunner: Executa um método quando a aplicação é iniciada

    @Autowired // Injeção de dependência automática
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		userRepository.save(u1);
        userRepository.save(u2);
    }

}
