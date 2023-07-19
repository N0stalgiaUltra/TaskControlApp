package com.example.taskcontrol.uxui.auth.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun CreateText(
    text: String,
    color: Color,
    modifier: Modifier
){
    Text(
        text = text,
        textAlign = TextAlign.Start,
        color = color,
        modifier = modifier.padding(
            start = 0.dp,
            end = 8.dp,
            bottom = 8.dp,
            top = 8.dp)
    )
}