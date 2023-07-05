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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.taskcontrol.uxui.data.UserViewModel

@Composable
fun textInputFragment(label: String, placeholder: String,
                      userViewModel: UserViewModel) {
    CreateText(
        text = label,
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier
    )

    when(label){
        "Username" -> createDataTextField(userViewModel = userViewModel, label = "Username", placeholder = placeholder)
        "Email" -> createDataTextField(userViewModel = userViewModel, label = "Email", placeholder = placeholder)
        "Password" -> createDataTextField(userViewModel = userViewModel, label = "Password", placeholder = placeholder)
        "Confirm Password" -> createDataTextField(userViewModel = userViewModel, label = "Confirm Password", placeholder = placeholder)

    }
    Spacer(modifier = Modifier.height(8.dp))
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun createDataTextField(userViewModel: UserViewModel, label: String, placeholder: String){
    val user = userViewModel.user

    when(label){
        "Username" -> {
            TextField(
                value = user.username,
                onValueChange = {userViewModel.createData(user.copy(username = it))},
                Modifier.fillMaxWidth(),
                maxLines = 1,
                colors = textFieldColors(
                    textColor = MaterialTheme.colorScheme.background,
                    containerColor = MaterialTheme.colorScheme.primary),
                placeholder = {
                    Text(text = placeholder, color = MaterialTheme.colorScheme.background)
                },
            )}
        "Email" -> {
            TextField(
                value = user.email,
                onValueChange = {userViewModel.createData(user.copy(email = it))},
                Modifier.fillMaxWidth(),
                maxLines = 1,
                colors = textFieldColors(
                    textColor = MaterialTheme.colorScheme.background,
                    containerColor = MaterialTheme.colorScheme.primary),
                placeholder = {
                    Text(text = placeholder, color = MaterialTheme.colorScheme.background)
                },
            )}
        "Password" ->{
            TextField(
                value = user.password,
                onValueChange = {userViewModel.createData(user.copy(password = it))},
                Modifier.fillMaxWidth(),
                maxLines = 1,
                colors = textFieldColors(
                    textColor = MaterialTheme.colorScheme.background,
                    containerColor = MaterialTheme.colorScheme.primary),
                placeholder = {
                    Text(text = placeholder, color = MaterialTheme.colorScheme.background)
                },
                visualTransformation = PasswordVisualTransformation()
            )
        }
        "Confirm Password" ->{

            TextField(
                value = userViewModel.confirmPassword,
                onValueChange = {
                    userViewModel.confirmPassword(it)
                },
                Modifier.fillMaxWidth(),
                maxLines = 1,
                colors = textFieldColors(
                    textColor = MaterialTheme.colorScheme.background,
                    containerColor = MaterialTheme.colorScheme.primary),
                placeholder = {
                    Text(text = placeholder, color = MaterialTheme.colorScheme.background)
                },
                visualTransformation = PasswordVisualTransformation())

        }
    }
}

