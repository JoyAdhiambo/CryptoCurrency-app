package com.shevaalex.android.cryptocurrencyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.shevaalex.android.cryptocurrencyapp.presentation.Screens
import com.shevaalex.android.cryptocurrencyapp.presentation.coin_detail.CoinDetailScreen
import com.shevaalex.android.cryptocurrencyapp.presentation.coin_list.CoinListScreen
import com.shevaalex.android.cryptocurrencyapp.presentation.theme.CryptocurrencyAppTheme


import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptocurrencyAppTheme {

           Surface(color = MaterialTheme.colors.background) {
             val navController  = rememberNavController()
             NavHost(navController = navController,
                 startDestination = Screens.CoinListScreen.route ){

                 composable(
                     route = Screens.CoinListScreen.route
                 ){
                    CoinListScreen(navController)
                 }

                 composable(
                     route = Screens.CoinDetailScreen.route + "/{coinId}"
                 ){
                    CoinDetailScreen()
                 }
             }

                }

            }
        }
    }
}



