package com.example.taskcontrol.uxui.auth.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.taskcontrol.uxui.auth.components.ButtonComponent
import com.example.taskcontrol.uxui.auth.components.textInputFragment
import com.example.taskcontrol.uxui.data.UserCardsViewModel

@Composable
fun LoginComponents(onNavigateToRegister: () -> Unit,
                            onNavigateToMain: ()-> Unit,
                            onNavigateToForget: ()-> Unit,
                            viewModel: LoginViewModel? = null,
                            cardsViewModel: UserCardsViewModel
){
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        contentAlignment = Alignment.Center
    ){
        Column(Modifier.padding(32.dp)) {
            val loginViewModel = viewModel?.loginUiState
            val isError = viewModel?.loginUiState?.loginError != null
            val context = LocalContext.current

            textInputFragment("L_Email", "email@email.com", viewModel)
            textInputFragment("L_Password", "password", viewModel)

            ButtonComponent(onClick = {
                viewModel?.loginUser(context)
            }, text = "Login")

            if(isError){
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = viewModel?.loginUiState?.loginError ?: "Unknown Error",
                    color = Color.Red
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row() {
                Text(
                    text = "Sign Up",
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .clickable { onNavigateToRegister() }
                        .weight(1f)
                )
                Text(
                    text = "Retrieve Account",
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.clickable { onNavigateToForget() }
                )
            }

            if(loginViewModel?.isLoading == true){
                CircularProgressIndicator()
            }
            /* TODO: ao terminar cadastro, navegar para login ou main page? */
            LaunchedEffect(key1 = viewModel?.hasUser){
                if(viewModel?.hasUser == true)
                    onNavigateToMain()
            }
        }

    }
}