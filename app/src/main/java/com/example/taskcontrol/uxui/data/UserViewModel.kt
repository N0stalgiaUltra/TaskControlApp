package com.example.taskcontrol.uxui.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class UserViewModel: ViewModel(){

    var user by mutableStateOf(User("", "", ""))
        private set
    var confirmPassword by mutableStateOf("")
        private set

    fun createData(newUser: User){
        user = newUser
    }

    fun confirmPassword(confPassword: String) {
        confirmPassword = confPassword
    }

    fun verifyPassword(): Boolean{
        return confirmPassword == user.password
    }
}

data class User(val email: String,
                val password: String,
                val username: String)