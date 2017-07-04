package com.book;

import com.book.config.ExceptionHandlerConfig;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAutoConfiguration
@EnableScheduling
public class BookApplication {

    @Bean
    public static PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
        PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
        ppc.setIgnoreUnresolvablePlaceholders(true);
        ppc.setLocations(new ClassPathResource("application.properties"));
        return ppc;
    }

    @Bean
    public static ExceptionHandlerConfig exceptionHandlerConfig() {
        return new ExceptionHandlerConfig();
    }

    public static void main(String[] args) {
        SpringApplication.run(
            new Class<?>[]{BookApplication.class}, args);
    }
}