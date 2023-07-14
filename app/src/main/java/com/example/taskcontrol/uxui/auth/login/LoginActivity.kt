package com.example.taskcontrol.uxui.auth.login

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.taskcontrol.ui.theme.TaskControlTheme
import com.example.taskcontrol.uxui.auth.components.TopAppBarrComponent
import com.example.taskcontrol.uxui.data.UserCardsViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(onNavigateToRegister: () -> Unit,
                onNavigateToMain: ()-> Unit,
                onNavigateToForget: ()-> Unit,
                loginViewModel: LoginViewModel,
                cardsViewModel: UserCardsViewModel
){
    Scaffold(
        topBar = { TopAppBarrComponent(text = "Login") }){
        paddingValues -> Modifier.padding(paddingValues)
        LoginComponents(
            onNavigateToRegister,
            onNavigateToMain,
            onNavigateToForget,
            loginViewModel,
            cardsViewModel
        )
    }



}
@Preview
@Composable

private fun LoginPreview(){
    TaskControlTheme(true) {
        LoginScreen({}, {}, {}, loginViewModel = LoginViewModel(),
        cardsViewModel = UserCardsViewModel())
    }
}



