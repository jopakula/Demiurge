package com.example.demiurge.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.demiurge.ui.viewModels.MainViewModel
import com.example.uikit.demiurge.button.MyButton
import com.example.uikit.demiurge.card.MyCard
import com.example.uikit.demiurge.common.MainBottom
import com.example.uikit.demiurge.common.MainText
import com.example.uikit.demiurge.common.MainTop
import com.example.uikit.demiurge.common.White

@Composable
fun MainScreen(
    viewModel: MainViewModel = viewModel()
) {
    val listState = rememberLazyListState()
    val label = MainText

    val cards = viewModel.getCards()

    LaunchedEffect(cards.size) {
        if (cards.isNotEmpty()) {
            listState.animateScrollToItem(cards.size - 1)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = Brush.verticalGradient(listOf(MainTop, MainBottom))),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier
                .padding(16.dp),
            text = label,
            color = White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium
        )
        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            state = listState,
        ) {
            items(cards) { cardType ->
                MyCard(cardType = cardType)
            }
        }
        MyButton(
            modifier = Modifier
                .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 16.dp)
                .navigationBarsPadding(),
            onClick = {
                viewModel.addCard()
            }
        )
    }
}

@Composable
@Preview
private fun MainScreenPreview() {
    MainScreen()
}