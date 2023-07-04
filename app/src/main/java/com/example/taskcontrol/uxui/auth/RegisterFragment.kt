package com.example.taskcontrol.uxui.auth

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(){

    Scaffold(
        topBar = { TopAppBarrComponent(text = "Register")}
    ) {
        paddingValues -> Modifier.padding(paddingValues)
        RegisterScreenComponents()

    }

}

@Preview
@Composable
fun PreviewRegisterScreen(){
    RegisterScreen()
}

@Composable
private fun RegisterScreenComponents(){

    Box(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
        , contentAlignment = Alignment.Center
    ) {
        Column() {

            textInputFragment(label = "Username", placeholder = "username", false)
            textInputFragment(label = "Email", placeholder = "email", false)
            textInputFragment(label = "Password", placeholder = "******", true)
            textInputFragment(label = "Confirm Password", placeholder = "********", true)
            Spacer(modifier = Modifier.height(10.dp))

            ButtonComponent(onClick = { /*TODO*/ }, text = "Create Account")

        }
    }
}