package com.example.taskcontrol.uxui.auth

import android.graphics.drawable.shapes.OvalShape
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
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
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
@Preview
@Composable
public fun LoginScreen(){
    TaskControlTheme(true) {
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
            contentAlignment = Alignment.Center
        ){
            Column(Modifier.padding(32.dp)) {
                textInputFragment("Email", "email@email.com")
                textInputFragment("Password", "********")

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
                        text = "Login",
                        modifier = Modifier.padding(8.dp),
                        fontSize = 20.sp,
                        color = MaterialTheme.colorScheme.background
                    )
                }

                Spacer(modifier = Modifier.height(5.dp))
                Row() {
                    Text(
                        text = "Criar Conta",
                        color = MaterialTheme.colorScheme.secondary,
                        modifier = Modifier
                            .clickable { /*TODO*/ }
                            .weight(1f)
                    )
                    Text(
                        text = "Recuperar Conta",
                        color = MaterialTheme.colorScheme.secondary,
                        modifier = Modifier.clickable { /*TODO*/ }
                    )
                }
            }
        }

    }

}

