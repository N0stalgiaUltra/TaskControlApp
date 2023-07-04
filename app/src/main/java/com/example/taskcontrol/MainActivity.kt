package com.example.taskcontrol

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.taskcontrol.ui.theme.TaskControlTheme
import com.example.taskcontrol.uxui.Navigation
import com.example.taskcontrol.uxui.auth.LoginFragment
import com.example.taskcontrol.uxui.auth.LoginScreen
import com.example.taskcontrol.uxui.auth.MainScreen
import com.example.taskcontrol.uxui.auth.RegisterScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskControlTheme(darkTheme = true) {
                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background)) {
                    Navigation()
                }

            }
        }
    }
}
