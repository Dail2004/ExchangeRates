package com.example.exchangerates.presentation.model

import com.example.exchangerates.common.IBaseDiffModel
import com.example.exchangerates.domain.model.ExchangeModel

data class ExchangeUI(
    val base: String,
    val disclaimer: String,
    val timestamp: Int,
    val license: String,
    override val rates: Map<String, Double>
): IBaseDiffModel

fun ExchangeModel.toUI() = ExchangeUI(
    base, disclaimer, timestamp, license, rates
)
