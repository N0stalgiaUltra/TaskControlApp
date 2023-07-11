package com.example.taskcontrol.uxui.data
import java.util.UUID

class UserCardRepository{
    private var _cards = mutableListOf<CardsState>()
    val cards get() = _cards.toList()

    fun addCard(card: CardsState){
        _cards.add(card)
    }

    /*
    fun removeCard(uuid: String){
        _cards.removeIf {
            uuid == it.uuid
        }
    }

    fun updateCard(card: CardsState){
        removeCard(card.uuid)
        addCard(card)
    }
    */
}


