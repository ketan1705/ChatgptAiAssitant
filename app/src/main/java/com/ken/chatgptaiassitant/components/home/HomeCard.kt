package com.ken.chatgptaiassitant.components.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ken.chatgptaiassitant.R
import com.ken.chatgptaiassitant.models.enums.HomeType

@Composable
fun HomeCard(onClick: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                Color.White
            ),
            modifier = modifier
                .fillMaxWidth()
                .clickable {
                    onClick()
                }
        ) {
            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.chatbot),
                    contentDescription = HomeType.TextChat.type,
                    modifier = modifier
                        .padding(20.dp)
                        .size(80.dp)
                )
                Text(
                    text = HomeType.TextChat.type,
                    fontWeight = FontWeight.W600,
                    fontSize = 20.sp,
                    modifier = modifier.padding(20.dp)
                )
            }
        }
        /*   Card(
               shape = RoundedCornerShape(16.dp),
               colors = CardDefaults.cardColors(
                   Color.White
               ),
               modifier = modifier
                   .fillMaxWidth()
           ) {
               Row(
                   modifier = modifier.fillMaxWidth(),
                   horizontalArrangement = Arrangement.SpaceEvenly,
                   verticalAlignment = Alignment.CenterVertically
               ) {
                   Text(
                       text = HomeType.ImageGenerator.type,
                       fontWeight = FontWeight.W600,
                       fontSize = 20.sp,
                       modifier = modifier
                           .padding(20.dp)
                   )
                   Image(
                       painter = painterResource(id = R.drawable.chatbot),
                       contentDescription = HomeType.ImageGenerator.type,
                       modifier = modifier
                           .padding(20.dp)
                           .size(80.dp)
                   )
               }
           }
           Card(
               shape = RoundedCornerShape(16.dp),
               colors = CardDefaults.cardColors(
                   Color.White
               ),
               modifier = modifier
                   .fillMaxWidth()
           ) {
               Row(
                   modifier = modifier.fillMaxWidth(),
                   horizontalArrangement = Arrangement.SpaceEvenly,
                   verticalAlignment = Alignment.CenterVertically
               ) {
                   Image(
                       painter = painterResource(id = R.drawable.chatbot),
                       contentDescription = HomeType.LanguageConverter.type,
                       modifier = modifier
                           .padding(20.dp)
                           .size(80.dp)
                   )
                   Text(
                       text = HomeType.LanguageConverter.type,
                       fontSize = 20.sp,
                       fontWeight = FontWeight.W600,
                       modifier = modifier.padding(20.dp)
                   )
               }
           }*/
    }
}