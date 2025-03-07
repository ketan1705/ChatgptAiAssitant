package com.ken.chatgptaiassitant.components.chat

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ken.chatgptaiassitant.R
import com.ken.chatgptaiassitant.models.ChatModel
import com.ken.chatgptaiassitant.models.enums.ChatRole

@Composable
fun ChatList(list: List<ChatModel>, modifier: Modifier = Modifier) {
    val listState = rememberLazyListState()

    LaunchedEffect(list.size) {
        if (list.isNotEmpty())
            listState.animateScrollToItem(list.size - 1)
    }
    LazyColumn(
        state = listState,
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.Top)
    ) {
        items(list)
        { item ->
            ChatBox(item)
        }
    }
}

@Composable
fun ChatBox(items: ChatModel) {

    val alignment = if (items.role == ChatRole.USER.role) Alignment.End else Alignment.Start

//    val backgroundColor =
//        if (items.role == ChatRole.USER.role) MaterialTheme.colorScheme.primary else Color.Gray

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = if (items.role == ChatRole.USER.role) 30.dp else 5.dp,
                end = if (items.role == ChatRole.USER.role) 5.dp else 30.dp,
                top = 5.dp,
                bottom = 5.dp
            )
    ) {


        Row(
            modifier = Modifier.align(alignment = alignment),
            verticalAlignment = Alignment.Top,
        )
        {

            if (items.role == ChatRole.AIMODEL.role) {
                ChatImage(role = items.role)
            }
            Box(
                modifier = Modifier
                    .padding(
                        start = if (items.role == ChatRole.USER.role) 0.dp else 5.dp,
                        end = if (items.role == ChatRole.USER.role) 5.dp else 0.dp
                    )
                    .clip(
                        shape = RoundedCornerShape(
                            topStart = if (items.role == ChatRole.USER.role) 30.dp else 20.dp,
                            topEnd = if (items.role == ChatRole.USER.role) 20.dp else 30.dp,
                            bottomStart = if (items.role == ChatRole.USER.role) 30.dp else 0.dp,
                            bottomEnd = if (items.role == ChatRole.USER.role) 0.dp else 30.dp,
                        )
                    )
                    .background(if (items.role == ChatRole.USER.role) Color.Black else Color.LightGray)
                    .padding(horizontal = 20.dp, vertical = 16.dp)
            )
            {
                Text(
                    text = items.message,
                    fontSize = 16.sp,
                    color = if (items.role == ChatRole.USER.role) Color.White else Color.Black,
                    fontWeight = FontWeight.Normal,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            if (items.role == ChatRole.USER.role) {
                ChatImage(role = items.role)
            }
        }


        /*Text(
            text = items.time,
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            style = MaterialTheme.typography.bodySmall
        )*/

    }
}

@Composable
fun ChatImage(modifier: Modifier = Modifier, role: String) {
    Image(
        painter = painterResource(
            if (role == ChatRole.USER.role) (R.drawable.img) else (R.drawable.chatbot),
        ),
        contentDescription = null,
        modifier = modifier
            .size(50.dp)
            .clip(CircleShape)
            .background(Color.Red.copy(0.7f), shape = CircleShape)
            .padding(5.dp)
    )
}