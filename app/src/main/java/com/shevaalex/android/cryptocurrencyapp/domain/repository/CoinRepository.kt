package com.shevaalex.android.cryptocurrencyapp.domain.repository

import com.shevaalex.android.cryptocurrencyapp.data.dto.CoinDetailDto
import com.shevaalex.android.cryptocurrencyapp.data.dto.Coindto

interface CoinRepository {

    suspend fun getCoins() : List<Coindto>

    suspend fun  getCoinById(coinId : String) : CoinDetailDto

}