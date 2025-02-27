package com.ken.chatgptaiassitant.screens

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ken.chatgptaiassitant.R
import com.ken.chatgptaiassitant.components.onboard.OnboardingItem
import com.ken.chatgptaiassitant.navigation.Routes
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    val scale = remember {
        Animatable(0f)
    }
    LaunchedEffect(Unit)
    {
        scale.animateTo(0.8f,
            animationSpec = tween(
                durationMillis = 500,
                easing = {
                    OvershootInterpolator(2f).getInterpolation(it)
                }
            )
        )

        delay(3000L)
        val onboardingItems = listOf(
            OnboardingItem(
                image = R.drawable.onboarding_img1,
                title = "Welcome to Our App",
                description = "Explore the latest features and enhancements in our app."
            ),
            OnboardingItem(
                image = R.drawable.onboarding_img2,
                title = "Discover Amazing Features",
                description = "Discover new ways to interact with our app."
            ),
            OnboardingItem(
                image = R.drawable.onboarding_img3,
                title = "Get Started Today",
                description = "Join us and experience the difference."
            )
        )
        navController.navigate(Routes.OnBoarding(onboardingItems))
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(R.drawable.chatbot),
            contentDescription = "ChatBot",
            modifier = Modifier
                .size(250.dp)
                .scale(scale.value)
        )

        Spacer(modifier = Modifier.height(15.dp))

        Text(
            text = "Welcome to Gemini Chatbot",
            style = MaterialTheme.typography.headlineMedium,
            color = Color.White,
        )
    }
}

