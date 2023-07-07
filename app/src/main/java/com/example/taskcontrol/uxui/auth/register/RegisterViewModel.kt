package com.example.taskcontrol.uxui.auth.register

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskcontrol.uxui.data.AuthRepository
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class RegisterViewModel(private var repository: AuthRepository = AuthRepository()): ViewModel(){

    val currentUser = repository.currentUser
    val hasUser = repository.hasUser()
    var registerUiState by mutableStateOf(RegisterUiState())
        private set

    fun onUsernameSignupChange(username: String){
        registerUiState = registerUiState.copy(usernameSignUp = username)
    }

    fun onEmailSignupChange(email: String){
        registerUiState = registerUiState.copy(emailSignUp = email)
    }

    fun onPasswordSignupChange(password: String){
        registerUiState = registerUiState.copy(passwordSignUp = password)
    }

    fun onConfirmPasswordSignupChange(confirmPassword: String){
        registerUiState = registerUiState.copy(confirmPasswordSignUp = confirmPassword)
    }

    private fun validateRegisterForm() =
        registerUiState.emailSignUp.isNotBlank() &&
                registerUiState.passwordSignUp.isNotBlank() &&
                registerUiState.usernameSignUp.isNotBlank() &&
                registerUiState.confirmPasswordSignUp.isNotBlank()

    fun createUser(context: Context) = viewModelScope.launch{
        try {
            if(!validateRegisterForm())
                throw IllegalArgumentException("One of provided data are empty")

            registerUiState = registerUiState.copy(isLoading = true)
            registerUiState = registerUiState.copy(signUpError = null)
            repository.createUser(registerUiState.emailSignUp, registerUiState.passwordSignUp){
                    isSuccesful ->
                if(isSuccesful){
                    Toast.makeText(
                        context,
                        "User Created",
                        Toast.LENGTH_SHORT
                    ).show()
                    registerUiState = registerUiState.copy(isSuccessSignUp = true)
                }
                else
                {
                    Toast.makeText(
                        context,
                        "User could not be created",
                        Toast.LENGTH_SHORT
                    ).show()
                    registerUiState = registerUiState.copy(isSuccessSignUp = false)
                }
            }
        }catch (e: Exception){
            registerUiState = registerUiState.copy(signUpError = e.localizedMessage)
            e.printStackTrace()
        }
        finally {
            registerUiState = registerUiState.copy(isLoading = false)
        }
    }
}

data class RegisterUiState(
    val emailSignUp: String = "",
    val passwordSignUp: String = "",
    val usernameSignUp: String = "",
    val confirmPasswordSignUp: String = "",
    val isLoading: Boolean = false,
    val isSuccessSignUp: Boolean = false,
    val signUpError: String? = null,
)