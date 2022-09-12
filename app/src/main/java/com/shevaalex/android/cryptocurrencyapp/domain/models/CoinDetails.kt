package com.shevaalex.android.cryptocurrencyapp.domain.models

import com.shevaalex.android.cryptocurrencyapp.data.dto.TeamMembers

data class CoinDetails(

    val coinId : String,
    val name  : String,
    val description  :String,
    val symbol : String,
    val rank : Int,
    val is_active : Boolean,
    val tags :List<String>,
    val team : List<TeamMembers>

)
