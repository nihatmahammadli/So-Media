package com.example.so_media.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.so_media.R
import com.example.so_media.ui.theme.DarkBlue

@Composable

fun AnimatedItem(visible: Boolean, delay: Int, content: @Composable () -> Unit) {
    val destiny = LocalDensity.current
    val slideDistance = with(destiny) { 50.dp.roundToPx() }
    AnimatedVisibility(
        visible = visible, enter = fadeIn(animationSpec = tween(700, delay)) + slideInVertically(
            animationSpec = tween(
                700, delay
            )
        ) { slideDistance }) {
        content()
    }
}

@Composable
@Preview
fun HeaderSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(DarkBlue)
            .padding(all = 32.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(top = 16.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.user_2), null, modifier = Modifier.size(50.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))
            Text(
                "Hi, Alex",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1f)
            )
            Image(
                painter = painterResource(R.drawable.notification),
                null,
            )
        }
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            "Find your Favorite\nHere!",
            color = Color.White,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 35.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = "",
            onValueChange = {},
            placeholder = { Text("Search...", color = Color.White.copy(0.7f)) },
            leadingIcon = {
                Icon(painterResource(R.drawable.search), null, tint = Color.White)
            },
            trailingIcon = {
                Icon(painterResource(R.drawable.microphone), null, tint = Color.White)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),
            shape = RoundedCornerShape(50.dp)
        )

    }
}
