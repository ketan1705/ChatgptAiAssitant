package com.ken.chatgptaiassitant.components.onboard

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BoardingFooter(pagerState: PagerState, onClick: () -> Unit) {
    val scope = rememberCoroutineScope()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)
    ) {
        if (pagerState.currentPage != 2) {
            Text(
                "Next", modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .clickable {
                        scope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        }
                    },
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
            Text(
                "Back", modifier = Modifier
                    .align(Alignment.BottomStart)
                    .clickable {
                        scope.launch {
                            val back = pagerState.currentPage - 1
                            if (back >= 0)
                                pagerState.animateScrollToPage(back)
                        }
                    },
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
        } else {
            OutlinedButton(
                onClick = {
                    Log.d("OnBoarding", "BoardingFooter:")
                    onClick()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter),
                colors = ButtonDefaults.buttonColors().copy(
                    containerColor = Color(0xFF3F51B5)
                )
            ) {
                Text(
                    "Get Started",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White,
                )
            }
        }
    }
}