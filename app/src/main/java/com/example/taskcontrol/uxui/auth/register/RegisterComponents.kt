package com.example.taskcontrol.uxui.auth.register

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.taskcontrol.uxui.auth.components.ButtonComponent
import com.example.taskcontrol.uxui.auth.components.textInputFragment
import com.example.taskcontrol.uxui.auth.login.LoginViewModel
import androidx.compose.ui.graphics.Color

@Composable
fun RegisterScreenComponents(registerViewModel: RegisterViewModel? = null, onNavigateToLogin: ()->Unit
){
    val registerUiState = registerViewModel?.registerUiState
    val isError = registerUiState?.signUpError != null
    val context = LocalContext.current

    Box(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
        , contentAlignment = Alignment.Center
    ) {
        Column {

            textInputFragment(label = "R_Username", placeholder = "Create Username", registerViewModel)
            textInputFragment(label = "R_Email", placeholder = "Create Email", registerViewModel)
            textInputFragment(label = "R_Password", placeholder = "Create Password", registerViewModel)
            textInputFragment(label = "R_Confirm Password", placeholder = "Confirm Password", registerViewModel)

            Spacer(modifier = Modifier.height(10.dp))

            if(isError){
                Text(text = registerUiState?.signUpError ?: "unknown error",
                    color = Color.Red)
            }

            Spacer(modifier = Modifier.height(5.dp))

            ButtonComponent(
                onClick = { registerViewModel?.createUser(context)
                },
                text = "Create Account")

            if(registerUiState?.isLoading == true){
                CircularProgressIndicator()
            }
            /* TODO: ao terminar cadastro, navegar para login ou main page? */
            LaunchedEffect(key1 = registerViewModel?.hasUser){
                if(registerViewModel?.hasUser == true)
                    onNavigateToLogin()
            }
        }
    }
}