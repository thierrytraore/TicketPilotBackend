package com.exnihilo.utilities;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Value("${server.port}")
    private String serverPort;

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(getInfo());
    }

    private Info getInfo() {
        return new Info()
                .title("TicketPilot API")
                .version("1.0.0")
                .description("Description TicketPilot API.")
                .license(getLicense());
    }

    private License getLicense() {
        return new License()
                .name("TicketPilot")
                .url("http://localhost:" + serverPort);
    }

}