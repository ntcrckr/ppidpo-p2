package org.ntcrckr.ppidpo.client.service;

import org.ntcrckr.ppidpo.client.service.impl.InfinitePollerImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ClientConfig {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(InfinitePoller infinitePoller) {
        return args -> infinitePoller.startEchoPolling();
    }

    @Bean
    public InfinitePoller infinitePoller(RestTemplate restTemplate) {
        return new InfinitePollerImpl(
                restTemplate,
                "http://localhost:8080/currencyRate",
                5
        );
    }
}
