package org.ntcrckr.ppidpo.server.service;

import org.ntcrckr.ppidpo.server.service.impl.ServerImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServerConfig {
    @Bean
    public CommandLineRunner run(Server server) {
        return args -> server.run();
    }

    @Bean
    public Server server() {
        return new ServerImpl("../server_input_folder");
    }
}
