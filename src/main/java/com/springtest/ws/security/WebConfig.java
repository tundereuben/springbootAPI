package com.springtest.ws.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry corsRegistry) {
//        registry.addMapping("/**");
corsRegistry
        // addmapping for the routes you want to add to the CORS server (/** for all routes)
        // allowedmethods(put, delete, patch, post etc. (* for all methods))
        //allowedorigins(ip:port)(* for all origins)
    .addMapping("/**")
        .allowedMethods("*")
        .allowedOrigins("http://localhost:4200");
    }
}
