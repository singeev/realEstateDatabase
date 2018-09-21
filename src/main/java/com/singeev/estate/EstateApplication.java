package com.singeev.estate;

import com.singeev.estate.entity.Role;
import com.singeev.estate.entity.User;
import com.singeev.estate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@SpringBootApplication
public class EstateApplication {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void init(){
        User user = new User(
                "Memory",
                "User",
                "Not Found",
                "admin@gmail.com",
                "+79218854675",
                passwordEncoder.encode("password"),
                Arrays.asList(
                        new Role("ROLE_USER"),
                        new Role("ROLE_ADMIN")));

        if (userRepository.findByEmail(user.getEmail()) == null){
            userRepository.save(user);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(EstateApplication.class, args);
    }
}
