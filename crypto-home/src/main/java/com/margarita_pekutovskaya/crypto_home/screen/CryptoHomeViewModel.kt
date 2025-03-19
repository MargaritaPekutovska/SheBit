package com.margarita_pekutovskaya.crypto_home.screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.margarita_pekutovskaya.api_crypto.CoinDataClient
import com.margarita_pekutovskaya.api_crypto.CoinDataRepository
import kotlinx.coroutines.launch

class CryptoHomeViewModel(
    private val coinDataRepository: CoinDataRepository
) : ViewModel() {

    init {
        viewModelScope.launch {
            try {
                val result = coinDataRepository.getMarketDataDetails(
                    currency = "usd",
                    coinIds = CryptoCoin.getCoinIds()
                )
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