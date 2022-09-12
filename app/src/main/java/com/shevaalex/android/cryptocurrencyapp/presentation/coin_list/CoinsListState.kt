package com.shevaalex.android.cryptocurrencyapp.presentation.coin_list

import com.shevaalex.android.cryptocurrencyapp.domain.models.Coin

data class CoinsListState(
    val isLoading:Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error : String = ""
)
