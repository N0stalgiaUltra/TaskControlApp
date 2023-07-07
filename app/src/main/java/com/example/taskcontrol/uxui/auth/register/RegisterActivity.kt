package com.example.taskcontrol.uxui.auth.register

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.taskcontrol.uxui.Screen
import com.example.taskcontrol.uxui.auth.components.TopAppBarrComponent
import com.example.taskcontrol.uxui.auth.login.LoginViewModel
import com.example.taskcontrol.uxui.data.UserValidationViewModel
import com.example.taskcontrol.uxui.data.UserViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(registerViewModel: RegisterViewModel, onNavigateToLogin: ()->Unit){

    Scaffold(
        topBar = { TopAppBarrComponent(text = "Register") }
    ) {
        paddingValues -> Modifier.padding(paddingValues)
        RegisterScreenComponents(registerViewModel, onNavigateToLogin)

    }

}

@Preview
@Composable
fun PreviewRegisterScreen(){
    RegisterScreen(registerViewModel = RegisterViewModel(), {})
}
