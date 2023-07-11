package com.example.taskcontrol.uxui.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import java.util.UUID

class UserCardsViewModel(private val repository: UserCardRepository = UserCardRepository()): ViewModel(){

    var cardsUiState by mutableStateOf(CardsState())
        private set

    fun addCard(card: CardsState){
        repository.addCard(card)
    }
    /*
    fun removeCard(uuid: String){
        repository.removeCard(uuid)
    }

    fun updateCard(card: CardsState){
        repository.updateCard(card)
    }*/

}
