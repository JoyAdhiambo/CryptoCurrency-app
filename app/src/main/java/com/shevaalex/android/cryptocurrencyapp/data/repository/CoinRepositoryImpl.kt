package com.shevaalex.android.cryptocurrencyapp.data.repository

import com.shevaalex.android.cryptocurrencyapp.data.dto.CoinDetailDto
import com.shevaalex.android.cryptocurrencyapp.data.dto.Coindto
import com.shevaalex.android.cryptocurrencyapp.data.remote.CoinPaprikaApi
import com.shevaalex.android.cryptocurrencyapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api : CoinPaprikaApi
) : CoinRepository{
    override suspend fun getCoins(): List<Coindto> {
       return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
    return api.getCoinById(coinId)
    }


}