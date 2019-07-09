package com.springtest.ws.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Configuration
@EnableSwagger2
@Profile("swagger")
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.springtest.ws"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .directModelSubstitute(LocalDate.class, java.sql.Date.class)
                .directModelSubstitute(LocalDateTime.class, java.util.Date.class)
                .genericModelSubstitutes(ResponseEntity.class);
    }
        private ApiInfo apiInfo(){
            return new ApiInfo(
                    "WebService",
                    "Swagger Webservice",
                    "1.0.0",
                    "To be provided",
                    new Contact("Tunde Ogunjimi", "www.turnkeyafrica.com", "tundeogunjimi@gmail.com"),
                    "GNU",
                    "To be provided"
            );
        }

//        private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("Swagger Web Service")
//                .description("List all APIs for iBroking App")
//                .version("1.0")
//                .build();
//        }
    }


