package com.shevaalex.android.cryptocurrencyapp.domain.use_cases.get_coin

import android.content.res.Resources
import com.shevaalex.android.cryptocurrencyapp.common.Resource
import com.shevaalex.android.cryptocurrencyapp.data.dto.toCoin
import com.shevaalex.android.cryptocurrencyapp.data.dto.toCoinDetail
import com.shevaalex.android.cryptocurrencyapp.domain.models.Coin
import com.shevaalex.android.cryptocurrencyapp.domain.models.CoinDetails
import com.shevaalex.android.cryptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.util.concurrent.Flow
import javax.inject.Inject

class getCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId : String): kotlinx.coroutines.flow.Flow<Resource<CoinDetails>> = flow{

        try {
            emit(Resource.Loading<CoinDetails>())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetails>(coin))

        }catch (e : HttpException){
            emit(Resource.Error<CoinDetails>(e.localizedMessage ?: "An Unexpected error occured"))

        }catch (e : IOException){
            emit(Resource.Error<CoinDetails>("Couldn't reach server, check your internet connection"))
        }
    }




}