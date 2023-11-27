package com.example.testreactive

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class TestReactiveApplication {
    fun main(args: Array<String>) {
        SpringApplication.run(TestReactiveApplication::class.java, *args)
    }
}
