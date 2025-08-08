package com.vincent.swaggy.ui.screens.auth

import android.widget.Toast
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.vincent.swaggy.model.User
import com.vincent.swaggy.navigation.ROUT_LOGIN
import com.vincent.swaggy.viewmodel.AuthViewModel
import com.vincent.swaggy.R
import com.vincent.swaggy.ui.theme.SwaggyTheme
import androidx.compose.ui.draw.rotate


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(
    authViewModel: AuthViewModel,
    navController: NavController,
    onRegisterSuccess: () -> Unit
) {
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var companyName by remember { mutableStateOf("") }
    var companyType by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var confirmPasswordVisible by remember { mutableStateOf(false) }
    val context = LocalContext.current
    val animatedAlpha by animateFloatAsState(
        targetValue = 1f,
        animationSpec = tween(durationMillis = 1500, easing = LinearEasing),
        label = "Animated Alpha"
    )
    val circleRotation by animateFloatAsState(
        targetValue = 360f,
        animationSpec = tween(durationMillis = 15000, easing = LinearEasing), label = ""
    )

    SwaggyTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.4f)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(Color(0xFF2196F3), Color(0xFFBBDEFB))
                        )
                    ),
                contentAlignment = Alignment.TopCenter
            ) {
                // Background Circles
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .offset(x = (-60).dp, y = (-40).dp)
                        .rotate(circleRotation)
                        .background(Color(0x33BBDEFB), CircleShape)
                )
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .offset(x = (140).dp, y = (10).dp)
                        .rotate(-circleRotation)
                        .background(Color(0x33BBDEFB), CircleShape)
                )

                // The Main UI
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 48.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .size(100.dp)
                            .clip(CircleShape)
                            .background(Color.White)
                            .padding(24.dp)
                    ) {
                        // Assuming you have a cube icon in your drawables
                        Image(
                            painter = painterResource(id = R.drawable.cube),
                            contentDescription = "Cube Icon",
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        "Swaggy",
                        fontSize = 30.sp,
                        color = Color.White,
                        fontFamily = FontFamily.Cursive
                    )
                }

                // Curved divider at the bottom of the blue background
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter)
                        .height(110.dp)
                        .background(Color.Transparent)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                color = Color.White,
                                shape = androidx.compose.ui.graphics.RectangleShape
                            )
                            .offset(y = (-80).dp) // Adjust this value to change the curve height
                    )
                }

            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.6f)
                    .background(Color.White)
                    .padding(horizontal = 24.dp)
                    .offset(y = (-70).dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                //Username
                OutlinedTextField(
                    value = username,
                    onValueChange = { username = it },
                    label = { Text("Username") },
                    leadingIcon = { Icon(Icons.Filled.Person, contentDescription = "Username Icon") },
                    modifier = Modifier.fillMaxWidth()
                )
                //End of username

                Spacer(modifier = Modifier.height(8.dp))

                //Email
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Email") },
                    leadingIcon = { Icon(Icons.Filled.Email, contentDescription = "Email Icon") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    modifier = Modifier.fillMaxWidth()
                )
                //End of email

                Spacer(modifier = Modifier.height(8.dp))

                //Role
                var role by remember { mutableStateOf("student") }
                val roleOptions = listOf("Buyer", "Seller", "Admin")
                var expanded by remember { mutableStateOf(false) }

                ExposedDropdownMenuBox(
                    expanded = expanded,
                    onExpandedChange = { expanded = !expanded }
                ) {
                    OutlinedTextField(
                        value = role,
                        onValueChange = {},
                        readOnly = true,
                        label = { Text("Select Role") },
                        trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                        modifier = Modifier.menuAnchor().fillMaxWidth()
                    )
                    ExposedDropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {
                        roleOptions.forEach { selectionOption ->
                            DropdownMenuItem(
                                text = { Text(selectionOption) },
                                onClick = {
                                    role = selectionOption
                                    expanded = false
                                }
                            )
                        }
                    }
                }
                //End of role

                Spacer(modifier = Modifier.height(8.dp))

                // Password Input Field with Show/Hide Toggle
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Password") },
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    leadingIcon = { Icon(Icons.Filled.Lock, contentDescription = "Password Icon") },
                    trailingIcon = {
                        val image = if (passwordVisible) painterResource(R.drawable.passwordshow) else painterResource(R.drawable.passwordhide)
                        IconButton(onClick = { passwordVisible = !passwordVisible }) {
                            Icon(image, contentDescription = if (passwordVisible) "Hide Password" else "Show Password")
                        }
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Confirm Password Input Field with Show/Hide Toggle
                OutlinedTextField(
                    value = confirmPassword,
                    onValueChange = { confirmPassword = it },
                    label = { Text("Confirm Password") },
                    visualTransformation = if (confirmPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    leadingIcon = { Icon(Icons.Filled.Lock, contentDescription = "Confirm Password Icon") },
                    trailingIcon = {
                        val image = if (confirmPasswordVisible) painterResource(R.drawable.passwordshow) else painterResource(R.drawable.passwordhide)
                        IconButton(onClick = { confirmPasswordVisible = !confirmPasswordVisible }) {
                            Icon(image, contentDescription = if (confirmPasswordVisible) "Hide Password" else "Show Password")
                        }
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Inside your RegisterScreen
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .background(
                            brush = Brush.horizontalGradient(
                                colors = listOf(
                                    MaterialTheme.colorScheme.primary,
                                    Color(0xFF42A5F5) // A lighter blue for the gradient effect
                                ),
                            ),
                            shape = MaterialTheme.shapes.medium
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Button(
                        onClick = {
                            if (username.isBlank() || email.isBlank() || password.isBlank() || confirmPassword.isBlank()) {
                                Toast.makeText(context, "All fields are required", Toast.LENGTH_SHORT).show()
                            } else if (password != confirmPassword) {
                                Toast.makeText(context, "Passwords do not match", Toast.LENGTH_SHORT).show()
                            } else {
                                authViewModel.registerUser(User(username = username, email = email, role = role, password = password))
                                onRegisterSuccess()
                            }
                        },
                        modifier = Modifier.fillMaxSize(),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
                    ) {
                        Text("Register", color = MaterialTheme.colorScheme.onPrimary)
                    }
                }
                Spacer(modifier = Modifier.height(24.dp))

                TextButton(
                    onClick = { navController.navigate(ROUT_LOGIN) }
                ) {
                    Text("Already have an account? Login", color = Color(0xFF2196F3))
                }
            }
        }
    }
}

