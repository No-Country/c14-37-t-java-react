package com.nocountryc14.listacheck;

//import io.swagger.v3.oas.models.OpenAPI;
//import io.swagger.v3.oas.models.info.Info;
//import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin(origins = "*")
public class ListacheckApplication {


    public static void main(String[] args) {

        SpringApplication.run(ListacheckApplication.class, args);
    }

//    @Bean
//    public OpenAPI customOpenAPI(){
//        return new OpenAPI()
//                .info(new Info()
//                        .title("Listacheck API")
//                        .version("1.0.0")
//                        .description("API for Listacheck application" +
//                                "This is a swagger Test")
//                        .termsOfService("http://swagger.io/terms")
//                        .license(new License().name("Apache 2.0")
//                                .url("http://springdoc.org")));
//
//    }



}