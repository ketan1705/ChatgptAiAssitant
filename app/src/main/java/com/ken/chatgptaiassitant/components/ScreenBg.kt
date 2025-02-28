package com.ken.chatgptaiassitant.components

import androidx.compose.ui.graphics.Brush
import com.ken.chatgptaiassitant.ui.theme.darkBlue
import com.ken.chatgptaiassitant.ui.theme.lightBlue

fun ScreenBg(): Brush {
    return Brush.Companion.linearGradient(
        listOf(
            lightBlue,
            darkBlue
        )
    )
}