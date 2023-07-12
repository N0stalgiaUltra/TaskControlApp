package com.example.taskcontrol.uxui.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.toLowerCase
import androidx.lifecycle.ViewModel
import java.util.UUID

class UserCardsViewModel(private val repository: UserCardRepository = UserCardRepository()): ViewModel(){

    var cardsUiState by mutableStateOf(CardsState())
        private set

    var todoCards by mutableStateOf<List<CardsState>>(emptyList())
    var doingCards by mutableStateOf<List<CardsState>>(emptyList())
    var doneCards by mutableStateOf<List<CardsState>>(emptyList())




    //Metodos OnChange
    // /*TODO: Adicionar possibilidade de edição de cards*/

    fun onChangeTitle(title: String, id: String) {
        val card = repository.getCard(id)
        card?.copy(title = title)
    }

    fun onChangeState(state: String, id: String){
        val card = repository.getCard(id)
        val updatedCard = card?.copy(state = state)

        if(updatedCard != null)
        {
            repository.updateCard(updatedCard)
            updateCards()
        }
    }

    //Metodos Crud
    fun addCard(card: CardsState){
        repository.addCard(card)
        updateCards()

    }

    fun deleteCard(card: CardsState){
        repository.removeCard(card.id)
        updateCards()

    }

    fun updateCard(card: CardsState){
        repository.updateCard(card)
        updateCards()
    }


    private fun updateCards(){
        val allCards = repository.getAllCards()
        todoCards = allCards.filter { it.state.lowercase() == "todo" }
        doingCards = allCards.filter { it.state.lowercase() == "doing" }
        doneCards = allCards.filter { it.state.lowercase() == "done" }

    }

}
