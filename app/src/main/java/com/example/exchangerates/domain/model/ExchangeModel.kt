package com.example.exchangerates.domain.model

data class ExchangeModel(
    val base: String,
    val disclaimer: String,
    val timestamp: Int,
    val license: String,
    val rates: Map<String, Double>
)