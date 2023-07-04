package com.example.taskcontrol.uxui.auth

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults.textFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun textInputFragment(label: String, placeholder: String) {
    CreateText(
        text = label,
        color = MaterialTheme.colorScheme.secondary,
        modifier = Modifier
    )

    TextField(
        value = placeholder,
        onValueChange = {},
        Modifier.fillMaxWidth(),
        colors = textFieldColors(
            textColor = MaterialTheme.colorScheme.background,
            containerColor = MaterialTheme.colorScheme.secondary)

    )
    Spacer(modifier = Modifier.height(8.dp))
}

