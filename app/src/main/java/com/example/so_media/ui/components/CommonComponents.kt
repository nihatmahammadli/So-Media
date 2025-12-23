package com.example.so_media.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp

@Composable

fun AnimatedItem(visible: Boolean, delay: Int, content: @Composable () -> Unit) {
    val destiny = LocalDensity.current
    val slideDistance = with(destiny){50.dp.roundToPx()}
    AnimatedVisibility(
        visible = visible,
        enter = fadeIn(animationSpec = tween(700,delay))
        + slideInVertically(animationSpec = tween(700,delay))
        {slideDistance}
    ) {
        content()
    }
}
