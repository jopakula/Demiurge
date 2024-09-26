package com.example.uikit.demiurge.button

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uikit.demiurge.common.ButtonBG
import com.example.uikit.demiurge.common.ButtonText
import com.example.uikit.demiurge.common.White

@Composable
fun MyButton(
    modifier: Modifier = Modifier,
    buttonHeight: Dp = 36.dp,
    buttonBGColor: Color = ButtonBG,
    buttonText: String = ButtonText,
    roundingSize: Dp = 4.dp,
    onClick: () -> Unit = {},
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(buttonHeight)
            .clip(RoundedCornerShape(roundingSize))
            .clickable { onClick() }
            .background(
                color = buttonBGColor,
                shape = RoundedCornerShape(roundingSize)
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Text(
            text = buttonText,
            color = White,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal)
    }
}

@Composable
@Preview
private fun MyButtonPreview() {
    MyButton()
}