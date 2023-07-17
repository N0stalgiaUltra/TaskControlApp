package com.example.taskcontrol.uxui.data

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.toLowerCase
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.UUID

class UserCardsViewModel(private val repository: UserCardRepository = UserCardRepository()): ViewModel(){

    var cardsUiState by mutableStateOf(CardsState())
        private set

    var todoCards by mutableStateOf<List<CardsState>>(emptyList())
    var doingCards by mutableStateOf<List<CardsState>>(emptyList())
    var doneCards by mutableStateOf<List<CardsState>>(emptyList())




    //Metodos OnChange
    // /*TODO: Adicionar possibilidade de edição de cards*/

    fun onChangeTitle(title: String, cardID: String) {
        val card = repository.getCard(cardID)
        card?.copy(title = title)
    }

    fun onChangeState(state: String, cardID: String) = viewModelScope.launch{
        val card = repository.getCard(cardID)
        val updatedCard = card?.copy(state = state)

        if(updatedCard != null)
        {
            repository.updateCard(updatedCard)
            updateCards(updatedCard.userAttached)
        }
    }

    //Metodos Crud
    fun addCard(card: CardsState) = viewModelScope.launch{
        repository.addCard(card)
        updateCards(card.userAttached)

    }

    fun deleteCard(card: CardsState) = viewModelScope.launch{
        repository.removeCard(card.id)
        updateCards(card.userAttached)

    }

    fun updateCard(card: CardsState) = viewModelScope.launch{
        repository.updateCard(card)
        updateCards(card.userAttached)
    }


    private suspend fun updateCards(userID: String){
        withContext(Dispatchers.IO){
            val allCards = repository.getAllUserCards(userID)
            todoCards = allCards.filter { it.state.lowercase() == "todo"}
            doingCards = allCards.filter { it.state.lowercase() == "doing" }
            doneCards = allCards.filter { it.state.lowercase() == "done" }
        }
    }


    fun getCards(userID: String) = viewModelScope.launch{
        updateCards(userID)
    }
}
