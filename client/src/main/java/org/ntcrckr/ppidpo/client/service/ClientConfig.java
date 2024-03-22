package org.ntcrckr.ppidpo.client.service;

import org.ntcrckr.ppidpo.client.service.impl.ClientImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientConfig {
    @Bean
    public CommandLineRunner run(Client client) {
        return args -> client.run();
    }

    @Bean
    public Client client() {
        return new ClientImpl("../server_input_folder");
    }
}
