package com.shevaalex.android.cryptocurrencyapp.domain.use_cases.get_coins

import android.content.res.Resources
import com.shevaalex.android.cryptocurrencyapp.common.Resource
import com.shevaalex.android.cryptocurrencyapp.data.dto.toCoin
import com.shevaalex.android.cryptocurrencyapp.domain.models.Coin
import com.shevaalex.android.cryptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.util.concurrent.Flow
import javax.inject.Inject

class getCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): kotlinx.coroutines.flow.Flow<Resource<List<Coin>>> = flow{

        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))

        }catch (e : HttpException){
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "An Unexpected error occured"))

        }catch (e : IOException){
            emit(Resource.Error<List<Coin>>("Couldn't reach server, check your internet connection"))
        }
    }




}