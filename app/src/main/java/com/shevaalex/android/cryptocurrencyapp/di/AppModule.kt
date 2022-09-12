package com.shevaalex.android.cryptocurrencyapp.di

import com.shevaalex.android.cryptocurrencyapp.common.Constants
import com.shevaalex.android.cryptocurrencyapp.common.Constants.BASE_URL
import com.shevaalex.android.cryptocurrencyapp.data.remote.CoinPaprikaApi
import com.shevaalex.android.cryptocurrencyapp.data.repository.CoinRepositoryImpl
import com.shevaalex.android.cryptocurrencyapp.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
@Provides
@Singleton
fun providePaprikaApi(): CoinPaprikaApi{
    return Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CoinPaprikaApi::class.java)
}

    @Provides
    @Singleton
    fun provideCoinRepository(api :CoinPaprikaApi): CoinRepository{
        return CoinRepositoryImpl(api)
    }
}