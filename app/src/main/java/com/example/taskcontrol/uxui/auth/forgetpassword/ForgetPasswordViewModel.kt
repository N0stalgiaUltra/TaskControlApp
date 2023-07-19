package com.example.taskcontrol.uxui.auth.forgetpassword

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskcontrol.uxui.data.AuthRepository
import kotlinx.coroutines.launch

class ForgetPasswordViewModel(private val repository: AuthRepository = AuthRepository())
    : ViewModel() {

    var forgetUiState by mutableStateOf(ForgotPasswordUser())
        private set

    fun onEmailChange(email: String){
        forgetUiState = forgetUiState.copy(email = email)
    }

    fun sendPasswordEmail(context: Context) = viewModelScope.launch{
        try{
            repository.forgotUserPassword(email = forgetUiState.email){
                isSuccesful ->
                    if(isSuccesful){
                        forgetUiState = forgetUiState.copy(emailSent = true)
                        Toast.makeText(
                            context, "Email Sent, check your email box",
                            Toast.LENGTH_SHORT).show()
                    }
                else{
                        forgetUiState = forgetUiState.copy(emailSent = false)

                        Toast.makeText(
                        context, "Could not send email, check your data and try again",
                        Toast.LENGTH_SHORT).show()
                }
            }
        }
        catch (E: Exception){
            E.printStackTrace()
            forgetUiState = forgetUiState.copy(emailSent = false)
            Toast.makeText(context, "${E.message}", Toast.LENGTH_SHORT).show()
        }
    }
}

data class ForgotPasswordUser(
    val email: String = "",
    val emailSent: Boolean = false
)
