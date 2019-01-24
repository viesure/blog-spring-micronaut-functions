package io.viesure.blog.springfunction;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@SpringBootApplication
@Slf4j
public class SpringFunctionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringFunctionApplication.class, args);
    }

    @Bean
    public Function<String, String> reverseString() {
        return stringMessage -> new StringBuilder(stringMessage).reverse().toString();
    }
}

