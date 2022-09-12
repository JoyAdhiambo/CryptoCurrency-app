package com.shevaalex.android.cryptocurrencyapp.data.remote

import com.shevaalex.android.cryptocurrencyapp.data.dto.CoinDetailDto
import com.shevaalex.android.cryptocurrencyapp.data.dto.Coindto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {
    @GET("/v1/coins")
    suspend fun getCoins() :List<Coindto>

  @GET("/v1/coins/{coinId}")
  suspend fun  getCoinById(@Path("coinId") coinId :String) : CoinDetailDto

}