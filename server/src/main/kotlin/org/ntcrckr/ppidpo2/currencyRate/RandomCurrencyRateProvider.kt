package org.ntcrckr.ppidpo2.currencyRate

import org.springframework.stereotype.Service
import java.util.*

@Service
class RandomCurrencyRateProvider : CurrencyRateProvider {
    var random: Random = Random()

    override fun getCurrentRate(): Double = getRandomDouble().round()

    private fun getRandomDouble(): Double = 100 + random.nextDouble(-10.0, 10.0)

    private fun Double.round(decimals: Int = 2): Double = "%.${decimals}f".format(this).toDouble()
}
