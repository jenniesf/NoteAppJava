package com.devmountain.noteApp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class Config {

    // create our custom Java Bean so that Spring can keep track of it, and
    // we can use it for Dependency Injection in our application’s context.
        // Spring is now keeping track of a new Bean called “passwordEncoder”
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
