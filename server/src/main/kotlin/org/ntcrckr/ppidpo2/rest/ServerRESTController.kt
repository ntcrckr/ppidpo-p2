package org.ntcrckr.ppidpo2.rest

import org.ntcrckr.ppidpo2.currencyRate.CurrencyRateProvider
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ServerRESTController(
    private val currencyRateProvider: CurrencyRateProvider,
) {
    @GetMapping("/currencyRate")
    fun currencyRate(): Double = currencyRateProvider.getCurrentRate()
}