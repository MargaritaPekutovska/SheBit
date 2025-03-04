package com.margarita_pekutovskaya.api_crypto

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CoinDataClient {

    private fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .build()
    }

    fun provideCoinDataClient(): CoinGeckoApiService {
        val retrofit = getInstance()
        return retrofit.create(CoinGeckoApiService::class.java)
    }

    companion object {
        private val BASE_URL = " https://pro-api.coingecko.com/"
    }
}

