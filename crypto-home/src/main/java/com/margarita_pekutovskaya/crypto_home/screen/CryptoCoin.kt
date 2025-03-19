package com.margarita_pekutovskaya.crypto_home.screen

enum class CryptoCoin(val coinName: String) {
    BITCOIN("bitcoin"),
    ETHEREUM("ethereum"),
    XRP("ripple"),
    SOLANA("solana"),
    ADA("cardano"),
    DOGECOIN("dogecoin");

    companion object {
        fun getCoinIds(): String {
            return entries.joinToString(",") { it.coinName }
        }
    }
}