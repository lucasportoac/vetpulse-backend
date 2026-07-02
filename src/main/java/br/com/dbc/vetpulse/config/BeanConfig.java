package br.com.dbc.vetpulse.config;

import br.com.dbc.vetpulse.domain.service.AgendamentoDomainService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public AgendamentoDomainService agendamentoDomainService() {
        return new AgendamentoDomainService();
    }
}
