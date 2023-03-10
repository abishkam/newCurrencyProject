package com.example.currencyproject.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

        public void addViewController(ViewControllerRegistry registry){
            registry.addViewController("/curr").setViewName("currency");
            registry.addViewController("/currencyList").setViewName("currencyList");
            registry.addViewController("/login").setViewName("login");
        }
}
