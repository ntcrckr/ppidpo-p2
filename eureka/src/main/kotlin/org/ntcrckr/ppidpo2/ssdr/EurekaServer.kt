package org.ntcrckr.ppidpo2.ssdr

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

@EnableEurekaServer
@SpringBootApplication
class EurekaServer

fun main(args: Array<String>) {
    runApplication<EurekaServer>(*args)
}