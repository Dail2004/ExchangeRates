package com.example.exchangerates.di

import com.example.exchangerates.data.repositories.ExchangeRatesRepositoriesImpl
import com.example.exchangerates.domain.repositories.ExchangeRatesRepositories
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoriesModule {
    @Binds
    abstract fun provideTopNewsRepository(
        exchangeRepositoriesImpl: ExchangeRatesRepositoriesImpl,
    ): ExchangeRatesRepositories
}