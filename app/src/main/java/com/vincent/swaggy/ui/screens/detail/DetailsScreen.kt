package com.vincent.swaggy.ui.screens.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.vincent.swaggy.R
import com.vincent.swaggy.navigation.ROUT_INTENT
import com.vincent.swaggy.navigation.ROUT_ITEM
import com.vincent.swaggy.ui.theme.Babyblue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(navController: NavController){
    //Scaffold

    var selectedIndex by remember { mutableStateOf(0) }

    Scaffold(
        //TopBar
        topBar = {
            TopAppBar(
                title = { Text("Other Products") },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigate(ROUT_ITEM)
                    }) {
                        Icon(Icons.Default.Menu, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Babyblue,
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White,
                    actionIconContentColor = Color.White
                ),
                actions = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Default.ShoppingCart,
                            contentDescription = "cart"
                        )
                    }
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Default.Notifications,
                            contentDescription = "notifications"
                        )
                    }
                }

            )
        },

        //BottomBar
        bottomBar = {
            NavigationBar(
                containerColor = Babyblue
            ){
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                    label = { Text("Home") },
                    selected = selectedIndex == 0,
                    onClick = { selectedIndex = 0
                        //navController.navigate(ROUT_HOME)
                    }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Favorite, contentDescription = "Favorites") },
                    label = { Text("Favorites") },
                    selected = selectedIndex == 1,
                    onClick = { selectedIndex = 1
                        // navController.navigate(ROUT_HOME)
                    }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Person, contentDescription = "Profile") },
                    label = { Text("Profile") },
                    selected = selectedIndex == 2,
                    onClick = { selectedIndex = 2
                        //  navController.navigate(ROUT_HOME)
                    }
                )



            }
        },

        //FloatingActionButton
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(ROUT_INTENT)
                },
                containerColor = Color.LightGray
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
            ) {

                Spacer(modifier = Modifier.height(10.dp))


                //Main Contents of the page
                //Search Bar
                var search by remember { mutableStateOf("") }
                OutlinedTextField(
                    value = search,
                    onValueChange = { search = it },
                    modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "search"
                        )
                    },
                    placeholder = { Text(text = "Search Products,Categories...") },
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = Babyblue,
                        focusedBorderColor = Color.Black
                    )
                )

                //End of Search Bar

                Text(
                    text = "Categories",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 20.dp, top = 10.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))

                //Row
                Row (
                    modifier = Modifier.padding(start = 20.dp)
                ){
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(Color.Black),
                        modifier = Modifier.padding(start = 10.dp,  bottom = 20.dp)
                    ) {
                        Text(text = "Shoes")
                    }
                    Spacer(modifier = Modifier.width(10.dp))

                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(Color.Black),
                        modifier = Modifier.padding(start = 10.dp,  bottom = 20.dp)
                    ) {
                        Text(text = "Watches")
                    }
                    Spacer(modifier = Modifier.width(10.dp))

                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(Color.Black),
                        modifier = Modifier.padding(start = 10.dp, bottom = 20.dp)
                    ) {
                        Text(text = "Shirts")
                    }

                    Spacer(modifier = Modifier.height(10.dp))


                }

                //End of Row

                    Text(
                        text = "Trending",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 20.dp,)
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                //Row
                Row(
                    modifier = Modifier
                        .padding(start = 10.dp, bottom = 20.dp)
                        .horizontalScroll(rememberScrollState())
                ) {
                    //Card
                    Card(
                        onClick = {},
                        modifier = Modifier.width(200.dp).height(250.dp),
                        elevation = CardDefaults.elevatedCardElevation(5.dp),
                        //colors = CardDefaults.cardColors(Babyblue)
                    ) {
                        Column (){
                            Image(
                                painter = painterResource(R.drawable.img_2),
                                contentDescription = "sweater",
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
                    Spacer(modifier = Modifier.width(10.dp))

                    //Card
                    Card(
                        onClick = {},
                        modifier = Modifier.width(200.dp).height(250.dp),
                        elevation = CardDefaults.elevatedCardElevation(5.dp),
                        //colors = CardDefaults.cardColors(Babyblue)
                    ) {
                        Column (){
                            Image(
                                painter = painterResource(R.drawable.img_2),
                                contentDescription = "sweater",
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
                    Spacer(modifier = Modifier.width(10.dp))

                    //Card
                    Card(
                        onClick = {},
                        modifier = Modifier.width(200.dp).height(250.dp),
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
                }
                //End of Row




















            }
        }
    )

    //End of scaffold


}

@Preview
@Composable
fun DetailsScreenPreview(){
    DetailsScreen(navController = rememberNavController())
}