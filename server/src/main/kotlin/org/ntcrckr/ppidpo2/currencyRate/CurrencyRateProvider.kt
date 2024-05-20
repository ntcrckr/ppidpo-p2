package org.ntcrckr.ppidpo2.currencyRate

interface CurrencyRateProvider {
    fun getCurrentRate(): Double
}