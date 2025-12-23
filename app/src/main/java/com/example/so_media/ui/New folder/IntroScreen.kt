package com.example.so_media.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.so_media.R
import com.example.so_media.ui.components.AnimatedItem
import com.example.so_media.ui.theme.DarkBlue
import com.example.so_media.ui.theme.LightBlue
import kotlinx.coroutines.delay

@Composable
@Preview
fun IntroScreen(onGetStartedClick: () -> Unit = {}) {
    var isVisible by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        delay(100)
        isVisible = true
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBlue)
    ) {

        Box(
            modifier = Modifier.wrapContentSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            Image(
                painter = painterResource(R.drawable.women),
                contentDescription = null,
                modifier = Modifier,
                contentScale = ContentScale.Fit
            )

            Image(
                painter = painterResource(R.drawable.arc_1),
                contentDescription = null,
                modifier = Modifier,
                contentScale = ContentScale.FillWidth
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(LightBlue)
                .padding(horizontal = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(32.dp))
            AnimatedItem(visible = isVisible, delay = 0) {
                Text(
                    text = "Welcome\n to the SoMedia",
                    color = Color.Black,
                    fontSize = 37.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    lineHeight = 40.sp
                )
            }
        }
    }
}