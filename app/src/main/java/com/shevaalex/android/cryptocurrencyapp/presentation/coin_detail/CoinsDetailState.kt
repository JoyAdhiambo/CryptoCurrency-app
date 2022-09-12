package com.shevaalex.android.cryptocurrencyapp.presentation.coin_detail

import com.shevaalex.android.cryptocurrencyapp.domain.models.Coin
import com.shevaalex.android.cryptocurrencyapp.domain.models.CoinDetails

data class CoinsDetailState(
    val isLoading:Boolean = false,
    val coin: CoinDetails? = null,
    val error : String = ""
)
