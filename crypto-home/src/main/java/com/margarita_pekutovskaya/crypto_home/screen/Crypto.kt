package com.margarita_pekutovskaya.crypto_home.screen

data class Crypto(val name:String, val price:Double)

val cryptoList = listOf(
    Crypto("Bitcoin", 51234.56),
    Crypto("Ethereum", 3250.75),
    Crypto("Solana", 110.20),
    Crypto("XRP", 2.58),
)
