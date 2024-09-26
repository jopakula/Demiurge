package com.example.demiurge.ui.viewModels

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.uikit.demiurge.card.CardType

class MainViewModel : ViewModel() {

    private val _cardList = mutableStateListOf<CardType>()
    val cardList: List<CardType> = _cardList

    private val cardTypes = listOf(CardType.Dead, CardType.Life, CardType.Alive)
    private var currentCardTypeIndex = 0

    fun addCard() {
        _cardList.add(cardTypes[currentCardTypeIndex])
        currentCardTypeIndex = (currentCardTypeIndex + 1) % cardTypes.size
    }
}
