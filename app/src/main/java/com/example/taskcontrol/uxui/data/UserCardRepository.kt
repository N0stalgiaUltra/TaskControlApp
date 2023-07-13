package com.example.taskcontrol.uxui.data
import android.util.Log
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.util.UUID
import kotlin.random.Random

class UserCardRepository {
    private var _cards = mutableListOf<CardsState>()
    val cards get() = _cards.toList()

    var userEmail: String = ""
    var cardID: String = ""
    val database: FirebaseDatabase = FirebaseDatabase.getInstance()
    val cardsRef: DatabaseReference = database.getReference("users/$userEmail")


    /*TODO: Remover possibilidades de duplicatas com ID*/
    fun addCard(card: CardsState) {
        if(card.id.isBlank()){
            userEmail = card.userAttached
            val newCard = card.copy(id = UUID.randomUUID().toString())
            _cards.add(newCard)
            addToDatabase(newCard)

        }

    }

    fun removeCard(id: String) {
        _cards.removeIf {
            id == it.id
        }
    }

    fun updateCard(card: CardsState) {
        removeCard(card.id)
        addCard(card)
    }

    fun getCard(id: String): CardsState?{
        return _cards.find { it.id == id}
    }

    fun getAllUserCards(email: String): List<CardsState>{
        return _cards.filter { it.userAttached == email }
    }
    fun getAllCards(): List<CardsState> {
        return _cards
    }


    //Database Methods
    fun addToDatabase(newCard: CardsState){
        cardID = newCard.id
        cardsRef.child(cardID).setValue(newCard)
    }
}

