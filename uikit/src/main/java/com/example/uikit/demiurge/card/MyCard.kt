package com.example.uikit.demiurge.card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uikit.demiurge.common.AliveCard
import com.example.uikit.demiurge.common.AliveCardDescription
import com.example.uikit.demiurge.common.DeadCard
import com.example.uikit.demiurge.common.DeadCardDescription
import com.example.uikit.demiurge.common.LifeCard
import com.example.uikit.demiurge.common.LifeCardDescription
import com.example.uikit.demiurge.common.White
import com.example.uikit.demiurge.icon.IconType
import com.example.uikit.demiurge.icon.MyIcon

enum class CardType {
    Dead,
    Alive,
    Life,
}

/**
 * Компонент для отображения карточки
 *
 */

@Composable
fun MyCard(
    modifier: Modifier = Modifier,
    cardHeight: Dp = 72.dp,
    cardType: CardType = CardType.Dead,
    roundingSize: Dp = 8.dp
) {
    val title =
        when (cardType) {
            CardType.Dead -> DeadCard
            CardType.Alive -> AliveCard
            CardType.Life -> LifeCard
        }

    val description =
        when (cardType) {
            CardType.Dead -> DeadCardDescription
            CardType.Alive -> AliveCardDescription
            CardType.Life -> LifeCardDescription
        }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(cardHeight)
            .clip(RoundedCornerShape(roundingSize))
            .background(color = White, shape = RoundedCornerShape(roundingSize)),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            MyIcon(
                iconType = when (cardType) {
                    CardType.Dead -> IconType.Dead
                    CardType.Alive -> IconType.Alive
                    CardType.Life -> IconType.Life
                }
            )
            Column(
                modifier = Modifier,

                ) {
                Text(
                    text = title,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = description,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal
                )
            }
        }
    }
}

@Composable
@Preview
private fun MyCardPreviewDead() {
    MyCard(
        cardType = CardType.Dead
    )
}

@Composable
@Preview
private fun MyCardPreviewAlive() {
    MyCard(
        cardType = CardType.Alive
    )
}

@Composable
@Preview
private fun MyCardPreviewLife() {
    MyCard(
        cardType = CardType.Life
    )
}