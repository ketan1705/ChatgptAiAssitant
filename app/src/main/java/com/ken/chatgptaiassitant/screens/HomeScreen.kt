package com.ken.chatgptaiassitant.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ken.chatgptaiassitant.components.home.HomeCard


@Composable
fun HomeScreen(onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        HomeCard(onClick = onClick)
    }
}