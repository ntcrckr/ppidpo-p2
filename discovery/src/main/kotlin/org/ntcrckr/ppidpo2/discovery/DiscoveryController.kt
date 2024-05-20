package org.ntcrckr.ppidpo2.discovery

import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

@RestController
class DiscoveryController(
    private val restTemplate: RestTemplate,
) {
    @GetMapping("/currencyRate")
    fun getRate(): ResponseEntity<*> {
        return restTemplate.exchange(
            /* url = */ "http://server/currencyRate",
            /* method = */ HttpMethod.GET,
            /* requestEntity = */ null,
            /* responseType = */ Double::class.java
        )
    }
}