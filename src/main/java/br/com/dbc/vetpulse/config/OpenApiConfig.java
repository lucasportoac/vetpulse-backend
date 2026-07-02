package br.com.dbc.vetpulse.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI vetPulseOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("VetPulse API")
                        .description("API para sistema de agendamento e telemedicina veterinária.")
                        .version("1.0.0"));
    }
}
