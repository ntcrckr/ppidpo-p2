package org.ntcrckr.ppidpo2.ssdr

import org.springframework.cloud.client.ServiceInstance
import org.springframework.cloud.client.discovery.DiscoveryClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController


@RestController
class ServiceDiscoveryController(
    private val discoveryClient: DiscoveryClient,
) {
    @GetMapping("/services")
    fun getServices(): List<String> = discoveryClient.services

    @GetMapping("/instances/{serviceName}")
    fun getServiceInstances(@PathVariable serviceName: String?): List<ServiceInstance> = discoveryClient.getInstances(serviceName)
}