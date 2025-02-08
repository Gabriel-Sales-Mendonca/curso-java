package com.gabriel.demo.config;

import com.gabriel.demo.entities.Order;
import com.gabriel.demo.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.gabriel.demo.entities.User;
import com.gabriel.demo.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    public UserRepository userRepository;
    @Autowired
    public OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        Order o1 = new Order(null, Instant.now());
        Order o2 = new Order(null, Instant.now());

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2));
    }
}
