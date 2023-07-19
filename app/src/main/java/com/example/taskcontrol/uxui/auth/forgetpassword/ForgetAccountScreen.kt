package com.example.taskcontrol.uxui.auth.forgetpassword

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.taskcontrol.ui.theme.TaskControlTheme
import com.example.taskcontrol.uxui.auth.components.ButtonComponent
import com.example.taskcontrol.uxui.auth.components.TopAppBarrComponent
import com.example.taskcontrol.uxui.auth.components.textInputFragment
import com.example.taskcontrol.uxui.data.UserCardsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForgetAccountScreen(viewModel: ForgetPasswordViewModel){
    Scaffold(topBar = { TopAppBarrComponent(text = "Retrieve Account") }) {
        paddingValues -> Modifier.padding(paddingValues)
        ForgetAccountScreenComponents(viewModel)
    }
}


@Preview
@Composable
private fun PreviewForgetScreen(){
    TaskControlTheme(darkTheme = true) {
    }
}

@Composable
private fun ForgetAccountScreenComponents(viewModel: ForgetPasswordViewModel){
    val context = LocalContext.current
    Box(modifier = Modifier
        .fillMaxSize(),
    contentAlignment = Alignment.Center){
        Column(modifier = Modifier.fillMaxWidth().padding(10.dp)) {

            textInputFragment(
                label = "F_Email",
                placeholder = "Type your email",
                userViewModel = viewModel)

            Spacer(modifier = Modifier.height(10.dp))

            ButtonComponent(
                onClick = {viewModel.sendPasswordEmail(context)},
                text = "Retrieve Account")
        }
    }
}