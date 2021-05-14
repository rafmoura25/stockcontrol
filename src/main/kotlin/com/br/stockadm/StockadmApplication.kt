package com.br.stockadm

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class StockadmApplication

fun main(args: Array<String>) {
	runApplication<StockadmApplication>(*args)
}
