package com.sda.quiz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class CoreConfiguration {
    @Bean
    public Random random() {
        return new Random();
    }
}
