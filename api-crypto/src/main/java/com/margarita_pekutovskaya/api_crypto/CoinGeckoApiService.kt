package com.margarita_pekutovskaya.api_crypto

import retrofit2.http.GET
import retrofit2.http.Path

interface CoinGeckoApiService {
    @GET("api/v3/coins/{id}")
    suspend fun fetchCoinById(@Path("id") coinId: String): CryptoDetailsModel
}