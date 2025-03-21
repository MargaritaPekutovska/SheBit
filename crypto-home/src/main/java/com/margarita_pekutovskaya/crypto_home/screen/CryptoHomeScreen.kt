package com.margarita_pekutovskaya.crypto_home.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.margarita_pekutovskaya.api_crypto.MarketDataDetails

@Composable
fun CryptoHomeScreen(
    modifier: Modifier = Modifier,
    viewModel: CryptoHomeViewModel = viewModel(factory = CryptoHomeViewModel.Factory),
) {
    LazyColumn(modifier.padding(16.dp)) {
        items(viewModel.dataCoin) { crypto: MarketDataDetails ->
            CryptoItem(crypto)
        }
    }
}

@Composable
private fun CryptoItem(crypto: MarketDataDetails) {
    Text(text = "${crypto.name}:${crypto.currentPrice} USD")
}

@Preview(showBackground = true)
@Composable
fun CryptoHomeScreenPreview() {
    CryptoHomeScreen()
}