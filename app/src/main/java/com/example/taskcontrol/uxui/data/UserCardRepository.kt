package com.example.taskcontrol.uxui.data
import java.util.UUID
import kotlin.random.Random

class UserCardRepository {
    private var _cards = mutableListOf<CardsState>()
    val cards get() = _cards.toList()

    fun GetRandomId(): Int{
        val random = Random.nextInt(0, 1000+1)
        return random
    }

    /*TODO: Remover possibilidades de duplicatas com ID*/
    fun addCard(card: CardsState) {
        card.copy(id = GetRandomId())
        _cards.add(card)
    }

    fun removeCard(id: Int?) {
        _cards.removeIf {
            id == it.id
        }
    }

    fun updateCard(card: CardsState) {
        removeCard(card.id)
        addCard(card)
    }

    fun getCard(id: Int?): CardsState?{
        return _cards.find { it.id == id}
    }
    fun getAllCards(): List<CardsState> {
        return _cards
    }

}

