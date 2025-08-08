package com.vincent.swaggy.ui.screens.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.vincent.swaggy.R
import com.vincent.swaggy.navigation.ROUT_HOME
import com.vincent.swaggy.navigation.ROUT_ITEM
import com.vincent.swaggy.ui.theme.Babyblue
import com.vincent.swaggy.ui.theme.Orange
import androidx.compose.ui.tooling.preview.Preview as Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(navController: NavController) {

    //Scaffold

    var selectedIndex by remember { mutableStateOf(0) }

    Scaffold(


        //BottomBar
        bottomBar = {
            NavigationBar(
                containerColor = Babyblue
            ) {
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                    label = { Text("Home") },
                    selected = selectedIndex == 0,
                    onClick = {
                        selectedIndex = 0
                        //navController.navigate(ROUT_HOME)
                    }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Favorite, contentDescription = "Favorites") },
                    label = { Text("Favorites") },
                    selected = selectedIndex == 1,
                    onClick = {
                        selectedIndex = 1
                        // navController.navigate(ROUT_HOME)
                    }
                )



            }
        },

        //FloatingActionButton
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* Add action */ },
                containerColor = Babyblue,
                modifier = Modifier.offset(y = 35.dp),
                shape = CircleShape
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        },
        floatingActionButtonPosition = FabPosition.Center,

        //Content
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
            ) {


                //Main Contents of the page
                Text(
                    text = "Hi Samantha", fontSize = 20.sp,
                    modifier = Modifier.padding(start = 10.dp, top = 150.dp, bottom = 5.dp),
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Here are your projects", fontSize = 15.sp,
                    modifier = Modifier.padding(start = 10.dp)
                )






            }

            Row (
                modifier = Modifier
                    .padding(start = 200.dp, bottom = 20.dp)
                    .verticalScroll(rememberScrollState())

            ){
                Column (){
                    Image(
                        painter = painterResource(R.drawable.img_6),
                        contentDescription = "woman",
                        modifier = Modifier
                            .size(width = 200.dp, height = 250.dp),
                        contentScale = ContentScale.Crop,
                    )

                }



                }


            //Row
            Row (
                modifier = Modifier
                    .padding(start = 10.dp, bottom = 20.dp, top = 270.dp)
                    .horizontalScroll(rememberScrollState())
            ){

                //Card
                Card(
                    onClick = {navController.navigate(ROUT_HOME)},
                    modifier = Modifier.width(150.dp).height(250.dp),
                    elevation = CardDefaults.elevatedCardElevation(5.dp),
                    colors = CardDefaults.cardColors(Babyblue)
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize().padding(top = 70.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ){
                        Image(
                            painter = painterResource(R.drawable.img_8),
                            contentDescription = "",
                            modifier = Modifier.width(50.dp).height(50.dp),
                            contentScale = ContentScale.Crop
                        )
                        Spacer(modifier = Modifier.height(3.dp))

                        Text(
                            text = "Cryptocurrency",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = "Landing Page",
                            fontSize = 15.sp
                        )
                    }

                }

                //End of Card
                Spacer(modifier = Modifier.width(10.dp))

                //Card
                Card(
                    onClick = {},
                    modifier = Modifier.width(150.dp).height(250.dp),
                    elevation = CardDefaults.elevatedCardElevation(5.dp),
                    colors = CardDefaults.cardColors(Orange)
                ) {
                    Column (
                        modifier = Modifier.fillMaxSize().padding(top = 70.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ){
                        Image(
                            painter = painterResource(R.drawable.img_11),
                            contentDescription = "",
                            modifier = Modifier.width(50.dp).height(50.dp),
                            contentScale = ContentScale.Crop
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = "Statistics",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(3.dp))
                        Text(
                            text = "Dashboard",
                            fontSize = 15.sp
                        )
                    }

                }

                //End of Card
                Spacer(modifier = Modifier.width(10.dp))

                //Card
                Card(
                    onClick = {},
                    modifier = Modifier.width(150.dp).height(250.dp),
                    elevation = CardDefaults.elevatedCardElevation(5.dp),
                    //colors = CardDefaults.cardColors(Babyblue)
                ) {
                    Column (){
                        Image(
                            painter = painterResource(R.drawable.img),
                            contentDescription = "Sweater",
                            modifier = Modifier.fillMaxWidth().height(160.dp),
                            contentScale = ContentScale.FillWidth
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = "Sneakers",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = "Ksh.3,400",
                            fontSize = 15.sp
                        )
                    }

                }

                //End of Card


            }//End of Row

            Column () {
                Text(
                    text = "Personal Tasks",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 550.dp, start = 5.dp)
                )

                Spacer(modifier = Modifier.height(10.dp))

               Card(
                   onClick = {},
                   modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 10.dp).height(80.dp),
                   colors = CardDefaults.cardColors(Color.White),
                   elevation = CardDefaults.elevatedCardElevation(5.dp)

               ) {

                   Row {
                       Image(
                           painter = painterResource(R.drawable.img_9),
                           contentDescription = "",
                           modifier = Modifier.size(size = 60.dp).padding(top = 15.dp),
                       )

                       Column (
                           modifier = Modifier.padding(start = 15.dp, top = 15.dp)
                       ){
                           Text(
                               text = "NDA Review for website project",

                           )

                           Text(
                               text = "Today 10pm",

                           )


                       }








                   }



               }

                Spacer(modifier = Modifier.height(10.dp))


                Card(
                    onClick = {},
                    modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 10.dp).height(80.dp),
                    colors = CardDefaults.cardColors(Color.White),
                    elevation = CardDefaults.elevatedCardElevation(5.dp)


                ) {
                    Spacer(modifier = Modifier.width(10.dp))

                    Row {
                        Image(
                            painter = painterResource(R.drawable.img_10),
                            contentDescription = "",
                            modifier = Modifier.size(size = 60.dp).padding(top = 15.dp),
                        )


                        Column (
                            modifier = Modifier.padding(start = 15.dp, top = 15.dp)
                        ){
                            Text(
                                text = "Email Reply for Green Project",


                            )

                            Text(
                                text = "Today 10pm",

                            )
                        }

                    }




                }




            }
















        }
    )

    //End of scaffold
}



@Preview
@Composable
fun DashboardScreenPreview(){
    DashboardScreen(navController = rememberNavController())
}