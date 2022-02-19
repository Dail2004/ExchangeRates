package com.example.exchangerates.data.network.dto

import com.example.exchangerates.domain.model.ExchangeModel
import com.google.gson.annotations.SerializedName

data class ExchangeRatesDto(
    @SerializedName("base")
    val base: String,
    @SerializedName("disclaimer")
    val disclaimer: String,
    @SerializedName("timestamp")
    val timestamp: Int,
    @SerializedName("license")
    val license: String,
    @SerializedName("rates")
    val rates: Map<String, Double>,
)

fun ExchangeRatesDto.toDomain() = ExchangeModel(
    base, disclaimer, timestamp, license, rates
)