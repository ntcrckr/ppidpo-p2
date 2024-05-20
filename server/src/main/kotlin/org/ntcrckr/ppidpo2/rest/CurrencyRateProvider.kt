package org.ntcrckr.ppidpo2.rest

interface CurrencyRateProvider {
    fun getCurrentRate(): Double
}