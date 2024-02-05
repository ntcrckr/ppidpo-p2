package org.ntcrckr.ppidpo.server.service.impl;

import org.ntcrckr.ppidpo.server.service.CurrencyRateProvider;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CurrencyRateProviderImpl implements CurrencyRateProvider {
    Random random = new Random();

    @Override
    public Double getCurrent() {
        return 100 + random.nextDouble(-10.0, 10.0);
    }
}
