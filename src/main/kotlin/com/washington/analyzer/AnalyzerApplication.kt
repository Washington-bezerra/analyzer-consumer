package com.washington.analyzer

import org.springframework.boot.autoconfigure.ImportAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication(scanBasePackages = [
	"com.washington.analyzer"
])
@EnableFeignClients
class AnalyzerApplication

fun main(args: Array<String>) {
	runApplication<AnalyzerApplication>(*args)
}
