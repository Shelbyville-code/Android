package com.vincent.swaggy.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.vincent.swaggy.R
import com.vincent.swaggy.navigation.ROUT_ITEM
import com.vincent.swaggy.ui.theme.Maroon
import com.vincent.swaggy.ui.theme.lightMaroon

@Composable
fun HomeScreen(navController: NavController){
    Column(
        modifier = Modifier.fillMaxSize().background(lightMaroon ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Spacer(modifier = Modifier.height(10.dp))
        Image(
            painter = painterResource(R.drawable.img),
            contentDescription = "Sweater",
            modifier = Modifier.size(300.dp).clip(shape = CircleShape),
            contentScale = ContentScale.Crop
        )





        Text(
            text = "Swaggy",
            fontSize = 40.sp,
            color = Maroon,
            fontFamily = FontFamily.Cursive,
            fontWeight = FontWeight.Thin
        )

        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Find More Products!!!",
            fontSize = 20.sp,
            fontWeight = FontWeight.Thin
        )

        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Beat the cold weather with our range of women's sweaters, cardigans, pullovers, and ponchos. Find wardrobe staples in different styles.",
            fontSize = 15.sp,
            fontWeight = FontWeight.Thin,
            textAlign = TextAlign.Center
        )

        Button(
            onClick = {
                navController.navigate(ROUT_ITEM)
            },
            colors = ButtonDefaults.buttonColors(Maroon),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp)
        ) {
            Text(text = "Get Started")
        }


    }

}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen(navController = rememberNavController())
}