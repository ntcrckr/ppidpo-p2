package org.ntcrckr.ppidpo2.discovery

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.client.loadbalancer.LoadBalanced
import org.springframework.context.annotation.Bean
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

@RestController
class DiscoveryController {
    @Bean
    @LoadBalanced
    fun restTemplate(): RestTemplate = RestTemplate()

    @GetMapping("/currencyRate")
    fun getRate(@Autowired restTemplate: RestTemplate): ResponseEntity<*> {
        return restTemplate.exchange(
            /* url = */ "http://server/currencyRate",
            /* method = */ HttpMethod.GET,
            /* requestEntity = */ null,
            /* responseType = */ Double::class.java
        )
    }
}