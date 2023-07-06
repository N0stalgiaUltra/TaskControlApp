package com.example.taskcontrol.uxui.auth.login

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.taskcontrol.ui.theme.TaskControlTheme
import com.example.taskcontrol.uxui.auth.components.TopAppBarrComponent
import com.example.taskcontrol.uxui.data.UserViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(onNavigateToRegister: () -> Unit,
                onNavigateToMain: ()-> Unit,
                onNavigateToForget: ()-> Unit, viewModel: LoginViewModel
){
    Scaffold(
        topBar = { TopAppBarrComponent(text = "Login") }){
        paddingValues -> Modifier.padding(paddingValues)
        LoginComponents(onNavigateToRegister, onNavigateToMain, onNavigateToForget, viewModel)
    }



}
@Preview
@Composable

private fun LoginPreview(){
    TaskControlTheme(true) {
        LoginScreen({}, {}, {}, viewModel= LoginViewModel())
    }
}



