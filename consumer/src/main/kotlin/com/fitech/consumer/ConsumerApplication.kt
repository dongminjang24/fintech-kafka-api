package com.fitech.consumer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication

@SpringBootApplication
@EntityScan("com.fintech.com.fintech.domain")
class ConsumerApplication

fun main(args: Array<String>){
    runApplication<ConsumerApplication>(*args)
}