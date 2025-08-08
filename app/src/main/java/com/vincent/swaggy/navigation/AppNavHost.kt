package com.vincent.swaggy.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.vincent.swaggy.data.UserDatabase
import com.vincent.swaggy.repository.UserRepository
import com.vincent.swaggy.ui.screens.about.AboutScreen
import com.vincent.swaggy.ui.screens.auth.LoginScreen
import com.vincent.swaggy.ui.screens.auth.RegisterScreen
import com.vincent.swaggy.ui.screens.category.CategoryScreen
import com.vincent.swaggy.ui.screens.contact.ContactScreen
import com.vincent.swaggy.ui.screens.dashboard.DashboardScreen
import com.vincent.swaggy.ui.screens.dashboard.DashboardScreen2
import com.vincent.swaggy.ui.screens.detail.DetailsScreen
import com.vincent.swaggy.ui.screens.form.FormScreen
import com.vincent.swaggy.ui.screens.home.HomeScreen
import com.vincent.swaggy.ui.screens.intent.IntentScreen
import com.vincent.swaggy.ui.screens.item.ItemScreen
import com.vincent.swaggy.ui.screens.products.AddProductScreen
import com.vincent.swaggy.ui.screens.products.EditProductScreen
import com.vincent.swaggy.ui.screens.products.ProductListScreen
import com.vincent.swaggy.ui.screens.scaffold.ScaffoldScreen
import com.vincent.swaggy.ui.screens.splash.SplashScreen
import com.vincent.swaggy.viewmodel.AuthViewModel
import com.vincent.swaggy.viewmodel.ProductViewModel

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUT_SPLASH,
    productViewModel: ProductViewModel = viewModel()
) {

    val context = LocalContext.current

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(ROUT_HOME) {
            HomeScreen(navController)
        }
        composable(ROUT_ABOUT) {
            AboutScreen(navController)
        }
        composable(ROUT_CONTACT) {
            ContactScreen(navController)
        }
        composable(ROUT_ITEM) {
            ItemScreen(navController)
        }
        composable(ROUT_CATEGORY) {
            CategoryScreen(navController)
        }
        composable(ROUT_SPLASH) {
            SplashScreen(navController)
        }
        composable(ROUT_SCAFFOLD) {
            ScaffoldScreen(navController)
        }
        composable(ROUT_DETAIL) {
            DetailsScreen(navController)
        }
        composable(ROUT_INTENT) {
            IntentScreen(navController)
        }
        composable(ROUT_DASHBOARD) {
            DashboardScreen(navController)
        }
        composable(ROUT_DASHBOARD2) {
            DashboardScreen2(navController)
        }
        composable(ROUT_FORM){
            FormScreen(navController)
        }


        //AUTHENTICATION

        // Initialize Room Database and Repository for Authentication
        val appDatabase = UserDatabase.getDatabase(context)
        val authRepository = UserRepository(appDatabase.userDao())
        val authViewModel: AuthViewModel = AuthViewModel(authRepository)
        composable(ROUT_REGISTER) {
            RegisterScreen(authViewModel, navController) {
                navController.navigate(ROUT_LOGIN) {
                    popUpTo(ROUT_REGISTER) { inclusive = true }
                }
            }
        }



        composable(ROUT_LOGIN) {
            LoginScreen(authViewModel, navController) {
                navController.navigate(ROUT_HOME) {
                    popUpTo(ROUT_LOGIN) { inclusive = true }
                }
            }
        }

        //END OF AUTHENTICATION

        //Products
        composable(ROUT_ADD_PRODUCT) {
            AddProductScreen(navController, productViewModel)
        }

        composable(ROUT_PRODUCT_LIST) {
            ProductListScreen(navController, productViewModel)
        }

        composable(
            route = ROUT_EDIT_PRODUCT,
            arguments = listOf(navArgument("productId") { type = NavType.IntType })
        ) { backStackEntry ->
            val productId = backStackEntry.arguments?.getInt("productId")
            if (productId != null) {
                EditProductScreen(productId, navController, productViewModel)
            }
        }

        //End of Products















    }
}





