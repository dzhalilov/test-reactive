package com.example.testreactive

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TestReactiveApplication

fun main(args: Array<String>) {
    runApplication<TestReactiveApplication>(*args)
}
