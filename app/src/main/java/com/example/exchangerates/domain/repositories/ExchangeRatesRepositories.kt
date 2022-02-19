package com.example.exchangerates.domain.repositories

import com.example.exchangerates.common.resource.Resource
import com.example.exchangerates.domain.model.ExchangeModel
import kotlinx.coroutines.flow.Flow

interface ExchangeRatesRepositories {
    fun fetchExchangeRates():Flow<Resource<List<ExchangeModel>>>
}