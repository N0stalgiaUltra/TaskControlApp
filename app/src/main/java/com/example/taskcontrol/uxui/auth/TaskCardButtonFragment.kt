package com.example.taskcontrol.uxui.auth

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CreateButton(text: String, color: Color){

    Button(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .padding(5.dp, 10.dp)
            .width(91.dp)
            .height(40.dp),
        colors = ButtonDefaults.buttonColors(color),
        onClick = { /*TODO*/ }) {
        Text(text = text,
            fontSize = 11.sp, color = Color.Black)
    }
}
