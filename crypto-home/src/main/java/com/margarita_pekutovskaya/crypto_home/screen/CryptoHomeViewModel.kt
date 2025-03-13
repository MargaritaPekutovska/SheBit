package com.margarita_pekutovskaya.crypto_home.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.margarita_pekutovskaya.api_crypto.CoinDataClient
import com.margarita_pekutovskaya.api_crypto.CoinDataRepository

class CryptoHomeViewModel(
    private val coinDataRepository: CoinDataRepository
) : ViewModel() {

    companion object {
        private const val TAG = "CosmeticCatalogueViewModel"

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