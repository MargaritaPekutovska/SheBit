package com.margarita_pekutovskaya.crypto_home.screen

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.margarita_pekutovskaya.api_crypto.CoinDataClient
import com.margarita_pekutovskaya.api_crypto.CoinDataRepository
import com.margarita_pekutovskaya.api_crypto.MarketDataDetails
import kotlinx.coroutines.launch

class CryptoHomeViewModel(
    private val coinDataRepository: CoinDataRepository
) : ViewModel() {

    var dataCoin by mutableStateOf<List<MarketDataDetails>> (emptyList())
    private set

    init {
        viewModelScope.launch {
            try {
                val result: List<MarketDataDetails> = coinDataRepository.getMarketDataDetails(
                    currency = "usd",
                    coinIds = CryptoCoin.getCoinIds()
                )
                dataCoin = result
                Log.d("CryptoHomeViewModel", "Data fetched successfully: $result")
            } catch (e: Exception) {
                Log.e("CryptoHomeViewModel", "Error fetching market data", e)
            }
        }
    }

    companion object {

        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                val repository = CoinDataRepository(coinBaseRemoteDataSource = CoinDataClient())
                return CryptoHomeViewModel(
                    repository
                ) as T
            }
        }
    }
}