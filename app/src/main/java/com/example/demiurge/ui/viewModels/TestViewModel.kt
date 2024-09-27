package com.example.demiurge.ui.viewModels

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.uikit.demiurge.card.CardType

class TestViewModel: ViewModel() {

    private val _cards = mutableStateListOf<CardType>()
    private val cards: List<CardType> = _cards

    private var aliveCounter = 0
    private var deadCounter = 0

    fun addDeadCard() {
        deadCounter++
        aliveCounter = 0
        _cards.add(CardType.Dead)
        if (deadCounter == 3) {
            removeLastLifeCard()
            deadCounter = 0
        }
    }

    fun addAliveCard() {
        aliveCounter++
        deadCounter = 0
        _cards.add(CardType.Alive)

        if (aliveCounter == 3) {
            _cards.add(CardType.Life)
            aliveCounter = 0
        }
    }

    private fun removeLastLifeCard() {
        val lastLifeIndex = _cards.lastIndexOf(CardType.Life)
        if (lastLifeIndex != -1) {
            _cards.removeAt(lastLifeIndex)
        }
    }

    fun getCards(): List<CardType> = cards
}