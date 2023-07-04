package com.example.taskcontrol.uxui.auth

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.taskcontrol.ui.theme.TaskControlTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForgetAccountScreen(){
    Scaffold(topBar = { TopAppBarrComponent(text = "Retrieve Account")}) {
        paddingValues -> Modifier.padding(paddingValues)
        ForgetAccountScreenComponents()
    }
}


@Preview
@Composable
private fun PreviewForgetScreen(){
    TaskControlTheme(darkTheme = true) {
        ForgetAccountScreen()
    }
}

@Composable
private fun ForgetAccountScreenComponents(){
    Box(modifier = Modifier
        .fillMaxSize(),
    contentAlignment = Alignment.Center){
        Column(modifier = Modifier.fillMaxWidth().padding(10.dp)) {
            textInputFragment(label = "Type your email",
                placeholder = "Type your email", isPassword = false)
            Spacer(modifier = Modifier.height(10.dp))
            ButtonComponent(onClick = { /*TODO*/ }, text = "Retrieve Account")
        }
    }
}