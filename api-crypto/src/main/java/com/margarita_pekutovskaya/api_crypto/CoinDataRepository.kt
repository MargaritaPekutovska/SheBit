package com.margarita_pekutovskaya.api_crypto

class CoinDataRepository(
    coinBaseRemoteDataSource: CoinDataClient,
) {
    private val coinDataClient = coinBaseRemoteDataSource.provideCoinDataClient()

    suspend fun getCoinById(coinId: String): CryptoDetailsModel {
        return coinDataClient.fetchCoinById(
            coinId = coinId
        )
    }

    suspend fun getMarketDataDetails(currency: String, coinIds: String): List<MarketDataDetails> {
        return coinDataClient.fetchMarketData(
            currency = currency,
            coinIds = coinIds,
        )
    }
}