package com.shevaalex.android.cryptocurrencyapp.data.dto

import com.shevaalex.android.cryptocurrencyapp.domain.models.Coin

data class Coindto(
    val id: String,
    val is_active: Boolean,
    val is_new: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)
// link json dto to project data
fun Coindto.toCoin(): Coin{
    return Coin(
        id = id,
        is_active = is_active,
        name= name,
        rank = rank,
        symbol= symbol
    )

}