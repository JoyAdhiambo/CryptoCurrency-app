package com.shevaalex.android.cryptocurrencyapp.presentation.coin_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shevaalex.android.cryptocurrencyapp.common.Constants
import com.shevaalex.android.cryptocurrencyapp.common.Resource
import com.shevaalex.android.cryptocurrencyapp.domain.use_cases.get_coin.getCoinUseCase
import com.shevaalex.android.cryptocurrencyapp.domain.use_cases.get_coins.getCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
  private val getCoinUseCase: getCoinUseCase,
   savedStateHandle: SavedStateHandle
): ViewModel(){
 private val _state =  mutableStateOf(CoinsDetailState())
    val state : State<CoinsDetailState> = _state
    init {

        savedStateHandle.get<String>(Constants.PARAM_ID)?.let { coinId ->
            getCoin(coinId)
        }

    }

    private fun getCoin(coinId :String){
        getCoinUseCase(coinId).onEach { result ->
            when (result){
                is Resource.Success ->{
                    _state.value = CoinsDetailState(coin = result.data)
                }
                is Resource.Error ->{
                    _state.value = CoinsDetailState(
                        error = result.message ?:
                        "An Unexpected error occured"
                    )
                }
                is Resource.Loading ->{
                    _state.value = CoinsDetailState(isLoading = true)

                }
            }

        }.launchIn(viewModelScope)
    }

}