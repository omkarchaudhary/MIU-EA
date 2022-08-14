package com.miu.ea.cs544.exam3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@SpringBootApplication
@EnableJms
public class Exam3Application {

    public static void main(String[] args) {
        SpringApplication.run(Exam3Application.class, args);
    }
    @Bean
    public SessionLocaleResolver sessionLocaleResolver(){
        SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
        sessionLocaleResolver.setDefaultLocale(Locale.US);
        return  sessionLocaleResolver;
    }
    @Bean
    public ResourceBundleMessageSource resourceBundleMessageSource(){
        ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
        resourceBundleMessageSource.setBasename("greeting");
        return resourceBundleMessageSource;
    }
}
