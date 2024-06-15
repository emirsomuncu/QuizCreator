package com.somuncu.QuizCreator;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class QuizCreatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizCreatorApplication.class, args);
	}

    @Bean
    public ModelMapper modelMapperBean() {
        return new ModelMapper();
    }
}
