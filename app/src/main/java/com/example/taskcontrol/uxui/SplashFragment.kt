package com.example.taskcontrol.uxui

import android.graphics.drawable.Drawable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.taskcontrol.R

@Preview
@Composable
fun ShowSplashFragment(){

    Box(
        Modifier.fillMaxSize().background(MaterialTheme.colorScheme.primary),
      contentAlignment = Alignment.Center
    ){
        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = "SplashLogo",
            modifier = Modifier.size(250.dp),
        )
    }

}