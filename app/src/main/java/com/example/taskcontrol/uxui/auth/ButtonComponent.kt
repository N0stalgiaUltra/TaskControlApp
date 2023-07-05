package com.example.taskcontrol.uxui.auth

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ButtonComponent(onClick: ()-> Unit, text: String){
    Button(
        onClick = { /*TODO*/ onClick() },
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(

            MaterialTheme.colorScheme.primary
        ),
        elevation = ButtonDefaults.buttonElevation(4.dp)

    ) {
        Text(
            text = "$text",
            modifier = Modifier.padding(8.dp),
            fontSize = 20.sp,
            color = MaterialTheme.colorScheme.background
        )
    }
}
