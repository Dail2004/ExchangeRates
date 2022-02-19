package com.example.exchangerates.domain.usecase

import com.example.exchangerates.domain.repositories.ExchangeRatesRepositories
import javax.inject.Inject

class ExchangeRatesRepositoriesUseCase @Inject constructor(
    private val exchangeRatesRepositories: ExchangeRatesRepositories,
) {
    operator fun invoke() = exchangeRatesRepositories.fetchExchangeRates()
}