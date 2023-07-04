package com.example.taskcontrol.uxui.auth

import android.graphics.drawable.shapes.OvalShape
import android.view.Surface
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskcontrol.ui.theme.TaskControlTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(onNavigateToRegister: () -> Unit,
                onNavigateToMain: ()-> Unit,
                onNavigateToForget: ()-> Unit
){
    Scaffold(
        topBar = { TopAppBarrComponent(text = "Login") }){
        paddingValues -> Modifier.padding(paddingValues)
        LoginComponents(onNavigateToRegister, onNavigateToMain, onNavigateToForget)
    }



}
@Preview
@Composable

private fun LoginPreview(){
    TaskControlTheme(true) {
        LoginScreen({}, {}, {})
    }
}

@Composable
private fun LoginComponents(onNavigateToRegister: () -> Unit,
                            onNavigateToMain: ()-> Unit,
                            onNavigateToForget: ()-> Unit){
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        contentAlignment = Alignment.Center
    ){
        Column(Modifier.padding(32.dp)) {
            textInputFragment("Email", "email@email.com", false)
            textInputFragment("Password", "********", true)

            ButtonComponent(onClick = { /*TODO: Fazer a validação do Login*/
                onNavigateToMain() }, text = "Login")

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
        }

    }
}
