package org.ntcrckr.ppidpo2.rest.impl

import org.ntcrckr.ppidpo2.rest.CurrencyRateProvider
import org.springframework.stereotype.Service
import java.util.*

@Service
class RandomCurrencyRateProvider : CurrencyRateProvider {
    var random: Random = Random()

    override fun getCurrentRate(): Double = 100 + random.nextDouble(-10.0, 10.0)
}
