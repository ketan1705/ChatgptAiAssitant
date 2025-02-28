package com.ken.chatgptaiassitant.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.ken.chatgptaiassitant.components.onboard.OnboardingItem
import com.ken.chatgptaiassitant.screens.ChatScreen
import com.ken.chatgptaiassitant.screens.HomeScreen
import com.ken.chatgptaiassitant.screens.OnBoardingScreen
import com.ken.chatgptaiassitant.screens.SplashScreen
import kotlin.reflect.typeOf

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    val startDestination = Routes.ChatScreen

    NavHost(navController = navController, startDestination = startDestination) {
        composable<Routes.Splash>
        {
            SplashScreen(navController = navController)
        }
        composable<Routes.OnBoarding>(
            typeMap = mapOf(typeOf<List<OnboardingItem>>() to onBoardingType)
        )
        {
            val onboardingItem = it.toRoute<Routes.OnBoarding>()
            OnBoardingScreen(onBoardingItems = onboardingItem) {
                navController.navigate(Routes.Home)
            }
        }
        composable<Routes.Home> {
            HomeScreen() {
                navController.navigate(Routes.ChatScreen)
            }
        }
        composable<Routes.ChatScreen> {
            ChatScreen()
        }
    }
}