package com.example.exchangerates.data.network.apisevice

import com.example.exchangerates.data.network.dto.ExchangeRatesDto
import com.example.exchangerates.data.network.dto.ResponseExchangeRates
import retrofit2.http.GET
import retrofit2.http.Query

interface ExchangeRatesApiService {

    @GET("latest.json")
    fun fetchLatest(
        @Query("app_id")app_id: String,
        @Query("base")base: String,
    ): ResponseExchangeRates<ExchangeRatesDto>
}