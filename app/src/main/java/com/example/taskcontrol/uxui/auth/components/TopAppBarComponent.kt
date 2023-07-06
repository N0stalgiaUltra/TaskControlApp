package com.example.taskcontrol.uxui.auth.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarrComponent(text: String){
    Surface(shadowElevation = 4.dp) {
        TopAppBar(
            colors = TopAppBarDefaults.
            largeTopAppBarColors(MaterialTheme.colorScheme.background),
            title = {
                Text(
                    text = "$text",
                    color = MaterialTheme.colorScheme.primary,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp, 16.dp)
                )
            },
            modifier = Modifier.fillMaxWidth(),
        )
    }

}