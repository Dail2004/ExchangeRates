package com.example.exchangerates.presentation.ui.fragment

import android.util.Log
import com.example.exchangerates.common.BaseViewModel
import com.example.exchangerates.data.network.dto.ExchangeRatesDto
import com.example.exchangerates.data.repositories.ExchangeRatesRepositoriesImpl
import com.example.exchangerates.domain.usecase.ExchangeRatesRepositoriesUseCase
import com.example.exchangerates.presentation.model.ExchangeUI
import com.example.exchangerates.presentation.model.toUI
import com.example.exchangerates.presentation.state.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class ExchangeRatesViewModel @Inject constructor(
    private val fetchExchange: ExchangeRatesRepositoriesUseCase,
) : BaseViewModel() {
    private val _exchangeRatesState = MutableStateFlow<UIState<List<ExchangeUI>>>(UIState.Loading())
    val exchangeRatesState: StateFlow<UIState<List<ExchangeUI>>> = _exchangeRatesState

    fun fetchExchangeRates() {
        Log.d("anime", "fuck1")
        _exchangeRatesState.subscribeTo(
            {fetchExchange()},
            {it.map { data -> data.toUI() }}
        )
    }
}