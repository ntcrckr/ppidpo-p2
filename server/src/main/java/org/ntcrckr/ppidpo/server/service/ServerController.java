package org.ntcrckr.ppidpo.server.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServerController {

    CurrencyRateProvider currencyRateProvider;

    public ServerController(CurrencyRateProvider currencyRateProvider) {
        this.currencyRateProvider = currencyRateProvider;
    }

    @GetMapping("/currencyRate")
    public Double getCurrencyRate() {
        return currencyRateProvider.getCurrent();
    }
}
