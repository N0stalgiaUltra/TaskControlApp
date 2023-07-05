package com.example.taskcontrol.uxui.data

import androidx.lifecycle.ViewModel

class UserValidationViewModel: ViewModel(){

    fun verifyPassword(password: String): String{

        return if(password.length > 3){
            ""
        } else{
            "A senha deve ter 3 caracteres"
        }
    }

    fun verifyConfirmPassword(password: String, confirmPassword:String): String{
        return if(password == confirmPassword) { "" }
        else{"As senhas devem ser iguais"}
    }

    fun verifyEmail(email: String):String{
        return if(email.contains('@') ){
            ""
        }
        else{
            "o Email deve conter um @"
        }
    }
}
