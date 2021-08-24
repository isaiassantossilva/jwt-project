package com.santos.jwtproject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//@SpringBootApplication
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class JwtProjectApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(JwtProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        var pss = new BCryptPasswordEncoder();
        System.out.println(pss.encode("1234"));
    }
}
