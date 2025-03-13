package com.margarita_pekutovskaya.api_crypto

class CoinDataRepository(
    private val coinBaseRemoteDataSource: CoinDataClient
) {
    suspend fun getCoinById(coinId: String): CryptoDetailsModel {
        return coinBaseRemoteDataSource.provideCoinDataClient().fetchCoinById(
            coinId = coinId
        )
    }
}