package com.spring.security.cors.springsecuritycors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@RestController
/*@CrossOrigin(origins="*")*/
public class SpringSecurityCorsApplication {

    /*@CrossOrigin(origins="http://localhost:9090")*/
    @GetMapping("/access")
    public String greeting() {
        return "Welcome to java techie portal";
    }
    /* Application level cors*/
    @Bean
    public WebMvcConfigurer configure() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/*").allowedOrigins("https://www.google.com/");
            }

        };
    }
    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityCorsApplication.class, args);
    }

}
