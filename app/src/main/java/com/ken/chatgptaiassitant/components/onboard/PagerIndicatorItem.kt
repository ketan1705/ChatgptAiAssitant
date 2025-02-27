package com.ken.chatgptaiassitant.components.onboard

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun PagerIndicatorItem(selected: Boolean) {

    val width = animateDpAsState(if (selected) 36.dp else 14.dp, label = "")

    Box(
        modifier = Modifier
            .padding(5.dp)
            .height(14.dp)
            .width(width.value)
            .clip(CircleShape)
            .background(
                if (selected) Color.White else Color.LightGray.copy(0.9f)
            )
    )

}