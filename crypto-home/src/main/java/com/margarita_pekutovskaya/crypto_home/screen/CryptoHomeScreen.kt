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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.margarita_pekutovskaya.api_crypto.MarketDataDetails

@Composable
fun CryptoHomeScreen(
    modifier: Modifier = Modifier,
    viewModel: CryptoHomeViewModel = viewModel(factory = CryptoHomeViewModel.Factory),
) {
    Column (
        modifier = modifier
            .fillMaxSize()
            .background(
                color = Color.Black
            )
            .padding(16.dp),
        verticalArrangement = Arrangement.Top
    ){
        Text(
            text= "Watch List", //resourses
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Gray,
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
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .background(Color.LightGray, shape = RoundedCornerShape(10.dp))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Image(
            painter = rememberAsyncImagePainter(crypto), //icon download
            contentDescription = crypto.name,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
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
                color = Color.Gray
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CryptoHomeScreenPreview() {
    CryptoHomeScreen()
}