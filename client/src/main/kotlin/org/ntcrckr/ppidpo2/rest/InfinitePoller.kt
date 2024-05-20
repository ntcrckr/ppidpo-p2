package org.ntcrckr.ppidpo2.rest

import org.springframework.scheduling.annotation.Scheduled
import org.springframework.web.client.RestTemplate

class InfinitePoller(
    private val restTemplate: RestTemplate,
    private val url: String,
) {
    @Scheduled(fixedRate = 5000)
    private fun poll() {
        val currencyRate = restTemplate.getForObject(url, Double::class.java)
        println("Received $currencyRate in response to REST request")
    }
}
