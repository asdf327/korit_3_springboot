package com.example.cardatabase2;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI carOatabaseOpenApi(){
        return new OpenAPI()
                .info(new Info()
                        .title("Car REST API")
                        .description("My Car Stock")
                        .version("1.0")
                );
    }
}
