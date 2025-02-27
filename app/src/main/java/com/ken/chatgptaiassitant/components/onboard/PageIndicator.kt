package com.ken.chatgptaiassitant.components.onboard


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun PagerIndicator(pageCount: Int, currentPage: Int, modifier: Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
    ) {

        repeat(pageCount) {
            PagerIndicatorItem(
                selected = it == currentPage
            )
        }

    }

}
