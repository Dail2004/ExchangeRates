package com.example.exchangerates.data.repositories

import com.example.exchangerates.common.BaseRepository
import com.example.exchangerates.common.resource.Resource
import com.example.exchangerates.data.network.apisevice.ExchangeRatesApiService
import com.example.exchangerates.data.network.dto.toDomain
import com.example.exchangerates.domain.model.ExchangeModel
import com.example.exchangerates.domain.repositories.ExchangeRatesRepositories
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ExchangeRatesRepositoriesImpl @Inject constructor(
    private val service: ExchangeRatesApiService,
) : BaseRepository(), ExchangeRatesRepositories {
    override fun fetchExchangeRates(): Flow<Resource<List<ExchangeModel>>> = doRequest {
        service.fetchLatest(
            "71de6ca435be460b97e4d0f4c9e3bc73",
            "USD"
        ).data.map { it.toDomain() }
    }
}