package com.ken.chatgptaiassitant.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ken.chatgptaiassitant.components.onboard.BoardingFooter
import com.ken.chatgptaiassitant.components.onboard.PagerIndicator
import com.ken.chatgptaiassitant.components.ScreenBg
import com.ken.chatgptaiassitant.navigation.Routes

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(onBoardingItems: Routes.OnBoarding, onClick: () -> Unit) {
    val onBoardingItems = onBoardingItems.onboardingItems.toList()
    val pagerState = rememberPagerState(
        pageCount = {
            onBoardingItems.size
        }
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ScreenBg()),
        horizontalAlignment = Alignment.Companion.CenterHorizontally,
    ) {

        HorizontalPager(state = pagerState) { currentPage ->
            Column(
                Modifier
                    .wrapContentSize()
                    .padding(top = 60.dp, bottom = 26.dp, start = 26.dp, end = 26.dp),
                horizontalAlignment = Alignment.Companion.CenterHorizontally

            ) {
                Image(
                    painter = painterResource(id = onBoardingItems[currentPage].image),
                    modifier = Modifier.size(300.dp, 200.dp),
                    alignment = Alignment.Companion.Center,
                    contentScale = ContentScale.Companion.Fit,
                    contentDescription = null
                )

                Text(
                    onBoardingItems[currentPage].title,
                    modifier = Modifier
                        .padding(top = 20.dp),
                    textAlign = TextAlign.Companion.Center,
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Companion.Normal,
                    lineHeight = 35.sp,
                    color = Color.Companion.White

                )
                Text(
                    onBoardingItems[currentPage].description,
                    modifier = Modifier.padding(top = 40.dp),
                    textAlign = TextAlign.Companion.Center,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Companion.Normal,
                    color = Color.Companion.White

                )

                PagerIndicator(
                    pageCount = onBoardingItems.size,
                    currentPage = pagerState.currentPage,
                    modifier = Modifier.padding(top = 80.dp)
                )
            }
        }

        BoardingFooter(
            pagerState = pagerState,
            onClick = onClick,
        )
    }
}
