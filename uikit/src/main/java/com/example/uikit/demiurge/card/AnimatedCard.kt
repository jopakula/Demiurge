package com.example.uikit.demiurge.card

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun AnimatedCard(cardType: CardType) {
    var visible by remember { mutableStateOf(false) }

    LaunchedEffect(cardType) {
        visible = true
    }

    AnimatedVisibility(
        visible = visible,
        enter = fadeIn() + scaleIn(initialScale = 0.1f),
        exit = fadeOut() + scaleOut(targetScale = 0.1f),
    ) {
        MyCard(cardType = cardType)
    }
}