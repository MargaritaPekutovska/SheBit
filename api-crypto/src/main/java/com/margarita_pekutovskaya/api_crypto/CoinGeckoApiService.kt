package com.margarita_pekutovskaya.api_crypto

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CoinGeckoApiService {
    @GET("api/v3/coins/{id}")
    suspend fun fetchCoinById(@Path("id") coinId: String): CryptoDetailsModel

    @GET("api/v3/coins/markets")
    suspend fun fetchMarketData(
        @Query("vs_currency") currency: String,
        @Query(value = "ids") coinIds: String
    ): List<MarketDataDetails>
}