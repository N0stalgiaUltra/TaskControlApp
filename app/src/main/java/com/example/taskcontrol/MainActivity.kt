package com.example.taskcontrol

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.taskcontrol.ui.theme.TaskControlTheme
import com.example.taskcontrol.uxui.Navigation
import com.example.taskcontrol.uxui.auth.login.LoginViewModel
import com.example.taskcontrol.uxui.data.UserViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            //entender esta linha.
            val loginViewModel = viewModel(modelClass = LoginViewModel::class.java)
            TaskControlTheme(darkTheme = true) {
                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background)) {
                    val viewModel = UserViewModel()
                    Navigation(viewModel, loginViewModel)
                }

            }
        }
    }
}
