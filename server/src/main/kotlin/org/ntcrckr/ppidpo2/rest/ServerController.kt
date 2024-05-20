package org.ntcrckr.ppidpo2.rest

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ServerController(
    private val currencyRateProvider: CurrencyRateProvider,
) {
    @GetMapping("/currencyRate")
    fun currencyRate(): Double = currencyRateProvider.getCurrentRate()
}