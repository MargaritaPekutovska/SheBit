package com.margarita_pekutovskaya.api_crypto

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class AuthenticationInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()
            .newBuilder()
            .addHeader(HEADER_NAME_ACCEPT, HEADER_VALUE_APPLICATION)
            .addHeader(HEADER_NAME_API_KEY, BuildConfig.COIN_GEKO_API_KEY)
            .build()
        return chain.proceed(request)
    }
}

private const val HEADER_NAME_ACCEPT = "accept"
private const val HEADER_VALUE_APPLICATION = "application/json"
private const val HEADER_NAME_API_KEY = "x-cg-api-key"