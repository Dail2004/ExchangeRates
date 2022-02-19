package com.example.exchangerates.presentation.ui.fragment

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.exchangerates.R
import com.example.exchangerates.common.BaseFragment
import com.example.exchangerates.databinding.FragmentExchangeRatesBinding
import com.example.exchangerates.presentation.state.UIState
import com.example.exchangerates.presentation.ui.adapter.ExchangeRatesAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ExchangeRatesFragment :
    BaseFragment<FragmentExchangeRatesBinding, ExchangeRatesViewModel>(R.layout.fragment_exchange_rates) {
    override val binding by viewBinding(FragmentExchangeRatesBinding::bind)
    override val viewModel: ExchangeRatesViewModel by viewModels()
    private val adapter = ExchangeRatesAdapter()

    override fun initialize() {
        Log.d("anime", "fuck")

        binding.recycler.layoutManager = LinearLayoutManager(context)
        binding.recycler.adapter = adapter

        viewModel.fetchExchangeRates()

        viewModel.exchangeRatesState.subscribe {
            when (it){
                is UIState.Error -> {}
                is UIState.Loading -> {}
                is UIState.Success -> {
                    adapter.submitList(it.data)
                    Log.e("TAG", "initialize: " + it.data )
                }
            }
        }
    }
}