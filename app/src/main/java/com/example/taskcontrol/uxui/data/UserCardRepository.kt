package com.example.taskcontrol.uxui.data
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import java.util.UUID
import kotlin.random.Random

class UserCardRepository {
    
    var currentUser = FirebaseAuth.getInstance().currentUser
    fun getUserID(): String = Firebase.auth.currentUser?.uid.orEmpty()


    private var _cards = mutableListOf<CardsState>()
    val cards get() = _cards.toList()

    val database: FirebaseDatabase = FirebaseDatabase.getInstance()



    fun addCard(card: CardsState) {
        if(card.id.isBlank()){
            val newCard = card.copy(id = UUID.randomUUID().toString())
            _cards.add(newCard)
            addToDatabase(newCard)

        }

    }

    fun removeCard(cardID: String) {
        _cards.removeIf {
            cardID == it.id
        }
    }

    fun updateCard(card: CardsState) {
        removeCard(card.id)
        addCard(card)
    }

    fun getCard(cardID: String): CardsState?{
        return _cards.find { it.id == cardID}
    }

    fun getAllUserCards(userID: String): List<CardsState>{
        return _cards.filter { it.userAttached == userID }
    }
    fun getAllCards(): List<CardsState> {
        return _cards
    }


    //Database Methods
    fun addToDatabase(newCard: CardsState){
        var userId: String = getUserID()
        val userRef: DatabaseReference = database.getReference("users").child(userId)
        val cardsRef = userRef.child("cards")

        Log.d("cards", "DADOS: ${newCard.id}, $userId")

        cardsRef.child(newCard.id).setValue(newCard)
    }
}

