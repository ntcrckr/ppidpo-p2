package org.ntcrckr.ppidpo.client.service.impl;

import org.ntcrckr.ppidpo.client.service.InfinitePoller;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import static java.util.concurrent.TimeUnit.SECONDS;

public class InfinitePollerImpl implements InfinitePoller {

    RestTemplate restTemplate;
    String url;
    Integer timeout;

    ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

    public InfinitePollerImpl(RestTemplate restTemplate, String url, Integer timeout) {
        this.restTemplate = restTemplate;
        this.url = url;
        this.timeout = timeout;
    }

    @Override
    public void startEchoPolling() {
        executor.scheduleAtFixedRate(this::poll, 0, timeout, SECONDS);
    }

    private void poll() {
        Double currencyRate = restTemplate.getForObject(url, Double.class);
        System.out.printf("%,.2f%n", currencyRate);
    }
}
