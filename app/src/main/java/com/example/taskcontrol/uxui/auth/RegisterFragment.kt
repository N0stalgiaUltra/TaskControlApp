package com.example.taskcontrol.uxui.auth

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun RegisterScreen(){
    Text(text = "Register",
        fontSize = 50.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth().padding(top = 32.dp),
        )
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
        , contentAlignment = Alignment.Center
    ) {
        Column() {

            textInputFragment(label = "Username", placeholder = "username")
            textInputFragment(label = "Email", placeholder = "email")
            textInputFragment(label = "Password", placeholder = "******")
            textInputFragment(label = "Confirm Password", placeholder = "********")
            Button(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    //change this to curr color theme
                    MaterialTheme.colorScheme.secondary
                )

            ) {
                Text(
                    text = "Register",
                    modifier = Modifier.padding(8.dp),
                    fontSize = 20.sp,
                    color = MaterialTheme.colorScheme.background
                )
            }

        }
    }
}


//Centralizado
//Box
//Username
//Name
//Senha
//Confirmar Senha
//Botão de registrar