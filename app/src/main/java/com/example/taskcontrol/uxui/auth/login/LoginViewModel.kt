package com.example.taskcontrol.uxui.auth.login

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskcontrol.MainActivity
import com.example.taskcontrol.uxui.data.AuthRepository
import com.example.taskcontrol.uxui.data.CardsState
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class LoginViewModel(
    private val repository: AuthRepository = AuthRepository()
): ViewModel() {
    val currentUser = repository.currentUser

    val hasUser: (Boolean)
        get() = repository.hasUser()

    var loginUiState by mutableStateOf(LoginUiState())
        private set


    fun onEmailChange(email: String){
        loginUiState = loginUiState.copy(email = email)
    }

    fun onPasswordChange(password: String){
        loginUiState = loginUiState.copy(password = password)
    }

    /*TODO: Determinar as regras de negócios para as validações*/
    private fun validateLoginForm(): String {
        var message = ""

        if(loginUiState.email.isBlank())
            message += "The email field is empty"

        if(loginUiState.password.isBlank())
            message += "\n The password field is empty"

        return message

    }



    fun loginUser(context: Context) = viewModelScope.launch{
            try {
                if(validateLoginForm() != "")
                    throw IllegalArgumentException(validateLoginForm())

                loginUiState = loginUiState.copy(isLoading = true)
                loginUiState = loginUiState.copy(loginError = null)

                repository.loginUser(loginUiState.email, loginUiState.password){
                    isSuccesful ->
                        if(isSuccesful){
                            getDataFromDatabase()
                            Toast.makeText(
                                context,
                                "Welcome Back ${loginUiState.username}",
                                Toast.LENGTH_SHORT
                            ).show()
                            loginUiState = loginUiState.copy(isSuccessLogin = true)

                        }
                    else
                    {
                        Toast.makeText(
                            context,
                            "Login failed, check your data",
                            Toast.LENGTH_SHORT
                        ).show()
                        loginUiState = loginUiState.copy(isSuccessLogin = false)
                    }
                }
            }catch (e: Exception){
                loginUiState = loginUiState.copy(loginError = e.localizedMessage)
                e.printStackTrace()
            }
            finally {
                loginUiState = loginUiState.copy(isLoading = false)
            }
    }

    private fun getDataFromDatabase() = viewModelScope.launch {
        repository.getUserFromDatabase(repository.getUserID()){
            user ->
            run {
                loginUiState = loginUiState.copy(
                    email = user?.emailSignUp.orEmpty(),
                    password = user?.passwordSignUp.orEmpty(),
                    username = user?.usernameSignUp.orEmpty(),
                    userUUID = user?.userUUID.orEmpty(),
                    )

            Log.d("user", "email: ${loginUiState.email}, " +
                    "username: ${loginUiState.username}, " +
                    "UUID: ${loginUiState.userUUID}")
            }
        }
    }

    fun logoutUser(context: Context) = viewModelScope.launch{
            Toast.makeText(context, "User signed out", Toast.LENGTH_SHORT).show()
            repository.logoutUser()
    }
}

data class LoginUiState(
    var email: String = "",
    val password: String = "",
    val username: String = "",
    val userUUID: String = "",
    val isLoading: Boolean = false,
    val isSuccessLogin: Boolean = false,
    val signUpError: String? = null,
    val loginError: String? = null,
    val cardsList: List<CardsState> = emptyList()
)