package com.fintech.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.ComponentScan


@EnableCaching
@SpringBootApplication
@EntityScan(basePackages = ["com.fintech.com.fintech.domain"])
@ComponentScan(basePackages = ["com.fintech"])
class ApiApplication
fun main(args: Array<String>) {
    runApplication<ApiApplication>(*args)
}