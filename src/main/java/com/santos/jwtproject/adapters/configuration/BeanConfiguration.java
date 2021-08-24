package com.santos.jwtproject.adapters.configuration;


import com.santos.jwtproject.application.ports.PasswordEncoderPort;
import com.santos.jwtproject.application.ports.UserRepositoryPort;
import com.santos.jwtproject.application.ports.UserServicePort;
import com.santos.jwtproject.application.services.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class BeanConfiguration {

    @Bean
    UserServicePort userService(UserRepositoryPort userRepository, PasswordEncoderPort passwordEncoder){
        return new UserServiceImpl(userRepository, passwordEncoder);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
