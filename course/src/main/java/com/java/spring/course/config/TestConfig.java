package com.java.spring.course.config;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.java.spring.course.enums.OrderStatus;
import com.java.spring.course.model.Category;
import com.java.spring.course.model.Order;
import com.java.spring.course.model.User;
import com.java.spring.course.repository.CategoryRepository;
import com.java.spring.course.repository.OrderRepository;
import com.java.spring.course.repository.UserRepository;

@Configuration // Indica que é uma classe de configuração
@Profile("test") // Indica que é uma classe de configuração específica para o perfil de teste
public class TestConfig implements CommandLineRunner { // CommandLineRunner: Executa um método quando a aplicação é
                                                       // iniciada

    @Autowired // Injeção de dependência automática
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.WAITING_PAYMENT, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.CANCELED, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.PAID, u1);

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        userRepository.save(u1);
        userRepository.save(u2);

        orderRepository.save(o1);
        orderRepository.save(o2);
        orderRepository.save(o3);

        categoryRepository.save(cat1);
        categoryRepository.save(cat2);
        categoryRepository.save(cat3);
    }

}
