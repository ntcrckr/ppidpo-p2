package org.ntcrckr.ppidpo2

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
@EnableDiscoveryClient
class ServerApplication

fun main(args: Array<String>) {
    runApplication<ServerApplication>(*args)
}