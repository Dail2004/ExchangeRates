package com.example.exchangerates.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.exchangerates.common.BaseComparator
import com.example.exchangerates.databinding.ExchangeRatesItemBinding
import com.example.exchangerates.domain.model.ExchangeModel
import com.example.exchangerates.presentation.model.ExchangeUI

class ExchangeRatesAdapter :
    ListAdapter<ExchangeUI, ExchangeRatesAdapter.ExchangeRatesViewHolder>
        (BaseComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExchangeRatesViewHolder {
        return ExchangeRatesViewHolder(
            ExchangeRatesItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ExchangeRatesViewHolder, position: Int) {
        getItem(position)?.let {
            holder.onBind(it)
        }
    }

    class ExchangeRatesViewHolder(
        private val binding: ExchangeRatesItemBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: ExchangeUI) {
            item.timestamp.and(1645275607)
            binding.base.text = item.base
            binding.rates.text = item.rates.toString()
            binding.disclaimer.text = item.disclaimer
            binding.license.text = item.license
        }
    }
}