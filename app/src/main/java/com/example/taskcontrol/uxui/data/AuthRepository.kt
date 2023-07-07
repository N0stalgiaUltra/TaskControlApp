package com.example.taskcontrol.uxui.data

import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class AuthRepository{
    //recupera a variavel current User.
    val currentUser: FirebaseUser? = Firebase.auth.currentUser

    fun hasUser(): Boolean = Firebase.auth.currentUser != null
    fun getUserID(): String = Firebase.auth.currentUser?.uid.orEmpty()

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

    fun logoutUser(){
        Firebase.auth.signOut()
    }
}