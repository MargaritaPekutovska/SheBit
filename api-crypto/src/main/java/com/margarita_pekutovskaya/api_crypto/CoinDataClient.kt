package com.margarita_pekutovskaya.api_crypto

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CoinDataClient {

    fun provideCoinDataClient(): CoinGeckoApiService {
        val retrofit = getRetrofitInstance()
        return retrofit.create(CoinGeckoApiService::class.java)
    }

    private fun getRetrofitInstance(): Retrofit {
        val client = OkHttpClient.Builder()
            .addInterceptor(AuthenticationInterceptor())
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .client(client)
            .build()
    }

    companion object {
        private val BASE_URL = " https://api.coingecko.com/"
    }
}