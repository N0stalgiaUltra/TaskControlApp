package com.example.taskcontrol.uxui.data

import com.example.taskcontrol.uxui.auth.login.LoginUiState
import com.example.taskcontrol.uxui.auth.register.RegisterUiState
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class AuthRepository{
    //recupera a variavel current User.
    val currentUser: FirebaseUser? = Firebase.auth.currentUser

    fun hasUser(): Boolean = Firebase.auth.currentUser != null
    fun getUserID(): String = Firebase.auth.currentUser?.uid.orEmpty()

    val database: FirebaseDatabase = FirebaseDatabase.getInstance()
    val usersRef: DatabaseReference = database.getReference("users")

    suspend fun createUser(
        email: String,
        password: String,
        onComplete:(Boolean)-> Unit
    ) = withContext(Dispatchers.IO){
        Firebase.auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener{
                if(it.isSuccessful){
                    onComplete(true)
                }
                else{
                    onComplete(false)
                }
            }.await()
    }

    suspend fun loginUser(
        email: String,
        password: String,
        onComplete:(Boolean)-> Unit
    ) = withContext(Dispatchers.IO){
        Firebase.auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener{
                if(it.isSuccessful){
                    onComplete(true)
                }
                else{
                    onComplete(false)
                }
            }.await()
    }

    suspend fun forgotUserPassword(
        email: String,
        onComplete: (Boolean) -> Unit)
        = withContext(Dispatchers.IO){
        Firebase.auth.sendPasswordResetEmail(email)
            .addOnCompleteListener {
                if(it.isSuccessful)
                    onComplete(true)

                else
                    onComplete(false)
            }.await()
    }
    suspend fun addUserToDatabase(user: RegisterUiState,
                                  onComplete: (Boolean) -> Unit) = withContext(Dispatchers.IO){
        usersRef.child(getUserID()).setValue(user).addOnCompleteListener {
            if(it.isSuccessful){
                addCardsNodeToDatabase()
                onComplete(true)
            }
            else
            {
                onComplete(false)
            }
        }.await()

    }

    private fun addCardsNodeToDatabase(){
        usersRef.child(getUserID()).child("cards").setValue(null);
    }

    fun getUserFromDatabase(userID: String, dataCallback: (RegisterUiState?) -> Unit){
        usersRef.child(userID).addListenerForSingleValueEvent(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val user = snapshot.getValue(RegisterUiState::class.java)
                dataCallback(user)
            }

            override fun onCancelled(error: DatabaseError) {
                dataCallback(null)
            }
        })


    }

    fun logoutUser(){
        Firebase.auth.signOut()
    }


}

