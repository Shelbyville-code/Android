package com.vincent.swaggy.ui.screens.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.vincent.swaggy.R
import com.vincent.swaggy.ui.theme.Babyblue

@Composable
fun DashboardScreen2(navController: NavController){
    Column (
        modifier = Modifier.fillMaxSize()
    ){
        Card(
            modifier = Modifier.fillMaxWidth().height(350.dp),
            shape = RoundedCornerShape(bottomStart = 60.dp),
            colors = CardDefaults.cardColors(Babyblue)
        ) {
            Column (

            ){
                Icons.Default.ArrowBack
                Text(
                    text = "Cryptocurrency"
                )
                Image(
                    painter = painterResource(R.drawable.img_12),
                    contentDescription = "",
                )

                Text(
                    text = "Discover the future of finance with our secure, fast, and user-friendly crypto platform. Buy, sell, and trade top cryptocurrencies with confidence — anytime, anywhere. Join the revolution today."
                )

            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DashboardScreen2Preview(){
    DashboardScreen2(navController = rememberNavController())
}