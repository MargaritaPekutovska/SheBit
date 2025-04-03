package com.margarita_pekutovskaya.crypto_home.screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.margarita_pekutovskaya.api_crypto.MarketDataDetails
import com.margarita_pekutovskaya.crypto_home.R

@Composable
fun CryptoHomeScreen(
    modifier: Modifier = Modifier,
    viewModel: CryptoHomeViewModel = viewModel(factory = CryptoHomeViewModel.Factory),
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(
                color = colorResource(R.color.black2)
            )
            .padding(16.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = stringResource(R.string.CryptoHomeScreenText),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(R.color.white),
            modifier = Modifier
                .padding(bottom = 16.dp)
        )

        LazyColumn(modifier.padding(16.dp)) {
            items(viewModel.dataCoin) { crypto: MarketDataDetails ->
                CryptoItem(crypto)
            }
        }
    }
}

@Composable
private fun CryptoItem(crypto: MarketDataDetails) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .background(
                color = colorResource(R.color.teal_200),
                shape = RoundedCornerShape(10.dp)
            )
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = rememberAsyncImagePainter(crypto.image),
            contentDescription = crypto.name,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .shadow(8.dp)
        )

        Spacer(modifier = Modifier.width(12.dp))

        Column {
            Text(
                text = crypto.name.toString(),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Text(
                text = "${crypto.currentPrice} ${CurrencyType.USD}",
                fontSize = 14.sp,
                color = colorResource(R.color.black)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CryptoHomeScreenPreview() {
    CryptoHomeScreen()
}