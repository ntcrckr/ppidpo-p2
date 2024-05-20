package org.ntcrckr.ppidpo2.rest

import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
class ClientConfig {
    @Bean
    fun restTemplate(builder: RestTemplateBuilder): RestTemplate = builder.build()

    @Bean
    fun infinitePoller(restTemplate: RestTemplate): InfinitePoller = InfinitePoller(
        restTemplate,
        "http://localhost:8080/currencyRate",
    )
}
