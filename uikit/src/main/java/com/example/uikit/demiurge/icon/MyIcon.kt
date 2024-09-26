package com.example.uikit.demiurge.icon

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.demiurge.common.AliveBottom
import com.example.uikit.demiurge.common.AliveTop
import com.example.uikit.demiurge.common.DeadBottom
import com.example.uikit.demiurge.common.DeadTop
import com.example.uikit.demiurge.common.LifeBottom
import com.example.uikit.demiurge.common.LifeTop

enum class IconType {
    Dead,
    Alive,
    Life,
}

/**
 * Компонент для отображения иконки
 *
 */


@Composable
fun MyIcon(
    modifier: Modifier = Modifier,
    iconType: IconType = IconType.Dead,
    iconSize: Dp = 40.dp,
    imageSize: Dp = 22.dp,
    iconColor: Color? = null,
) {

    val backgroundColor =
        when (iconType) {
            IconType.Dead -> listOf(DeadTop, DeadBottom)
            IconType.Alive -> listOf(AliveTop, AliveBottom)
            IconType.Life -> listOf(LifeTop, LifeBottom)
        }

    val icon =
        when (iconType) {
            IconType.Dead -> painterResource(id = R.drawable.dead)
            IconType.Alive -> painterResource(id = R.drawable.alive)
            IconType.Life -> painterResource(id = R.drawable.life)
        }

    Box(
        modifier = modifier
            .size(iconSize)
            .clip(RoundedCornerShape(iconSize))
            .background(
                brush = Brush.verticalGradient(backgroundColor),
                shape = RoundedCornerShape(iconSize)
            ),
        contentAlignment = Alignment.Center
    ) {

        Image(
            modifier = Modifier
                .size(imageSize),
            painter = icon,
            contentDescription = null,
            contentScale = ContentScale.Fit,
            colorFilter = iconColor?.let { ColorFilter.tint(it) }
        )
    }
}

@Composable
@Preview
private fun MyIconPreviewDead() {
    MyIcon(
        iconType = IconType.Dead
    )
}

@Composable
@Preview
private fun MyIconPreviewAlive() {
    MyIcon(
        iconType = IconType.Alive
    )
}

@Composable
@Preview
private fun MyIconPreviewLife() {
    MyIcon(
        iconType = IconType.Life
    )
}

