package com.example.taskcontrol.uxui.data
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase
import java.util.UUID
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class UserCardRepository {
    
    var currentUser = FirebaseAuth.getInstance().currentUser
    fun getUserID(): String = Firebase.auth.currentUser?.uid.orEmpty()


    private var _cards = mutableListOf<CardsState>()

    val database: FirebaseDatabase = FirebaseDatabase.getInstance()



    fun addCard(card: CardsState) {

        if(card.id.isBlank()){
            val newCard = card.copy(id = UUID.randomUUID().toString())
            _cards.add(newCard)
            addCardToDatabase(newCard)

        }
        else
        {
            _cards.add(card)
            addCardToDatabase(card)
        }

    }

    fun removeCard(cardID: String) {
        _cards.removeIf {
            cardID == it.id
        }
        removeCardFromDatabase(cardID)
    }

    fun updateCard(card: CardsState) {
        removeCard(card.id)
        addCard(card)
    }

    fun getCard(cardID: String): CardsState?{
        return _cards.find { it.id == cardID}
    }

    suspend fun getAllUserCards(userID: String): List<CardsState> = suspendCoroutine{
        continuation -> getCardsFromDatabase(userID){
            cards -> val cardList = cards.filter { it?.userAttached == userID }
            continuation.resume(cardList as List<CardsState>)
        }
    }
    fun getAllCards(): List<CardsState> {
        return _cards
    }


    //Database Methods
    private fun addCardToDatabase(newCard: CardsState){
        var userId: String = getUserID()
        val userRef: DatabaseReference = database.getReference("users").child(userId)
        val cardsRef = userRef.child("cards")
        cardsRef.child(newCard.id).setValue(newCard)
    }
    private fun removeCardFromDatabase(cardID: String){
        var userId: String = getUserID()
        val userRef: DatabaseReference = database.getReference("users").child(userId)
        val cardsRef = userRef.child("cards")
        cardsRef.child(cardID).removeValue()
    }
    private fun getCardsFromDatabase(userID: String, dataCallback:(List<CardsState?>)-> Unit){
        val userRef: DatabaseReference = database.getReference("users").child(userID)
        val cardsRef = userRef.child("cards")
        cardsRef.addListenerForSingleValueEvent(object: ValueEventListener{
            val cardsList : MutableList<CardsState?> = mutableListOf()

            override fun onDataChange(snapshot: DataSnapshot) {
                for(cardSnapshot in snapshot.children){
                    val card = cardSnapshot.getValue(CardsState::class.java)
                    cardsList.add(card)
                }
                _cards = cardsList.filterNotNull().toMutableList()
                dataCallback(_cards)

            }

            override fun onCancelled(error: DatabaseError) {
                Log.d("error", error.message)
                dataCallback(emptyList())
            }
        })
    }


}

