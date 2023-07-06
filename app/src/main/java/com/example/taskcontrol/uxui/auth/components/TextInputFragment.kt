package com.example.taskcontrol.uxui.auth.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults.textFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.taskcontrol.uxui.auth.login.LoginViewModel
import com.example.taskcontrol.uxui.data.UserViewModel

@Composable
fun textInputFragment(label: String, placeholder: String,
                      loginViewModel: LoginViewModel ?= null) {

    CreateText(
        text = label.drop(2),
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier
    )

    when(label){
        "R_Username" -> createRegisterTextField(viewModel = loginViewModel, label = "Username", placeholder = placeholder)
        "R_Email" -> createRegisterTextField(viewModel = loginViewModel, label = "Email", placeholder = placeholder)
        "R_Password" -> createRegisterTextField(viewModel = loginViewModel, label = "Password", placeholder = placeholder)
        "R_Confirm Password" -> createRegisterTextField(viewModel = loginViewModel, label = "Confirm Password", placeholder = placeholder)
        "L_Email" -> createLoginTextField(viewModel = loginViewModel, label = "Email", placeholder = placeholder)
        "L_Password" -> createLoginTextField(viewModel = loginViewModel, label = "Password", placeholder = placeholder)
    }
    Spacer(modifier = Modifier.height(8.dp))
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun createRegisterTextField(viewModel: LoginViewModel?= null, label: String, placeholder: String){

    when(label){
        "Username" -> {
            OutlinedTextField(
                value = viewModel?.loginUiState?.usernameSignUp ?: "",
                onValueChange = {viewModel?.onUsernameSignupChange(username = it)},
                Modifier.fillMaxWidth(),
                maxLines = 1,
                colors = textFieldColors(
                    textColor = MaterialTheme.colorScheme.background,
                    containerColor = MaterialTheme.colorScheme.primary),
                placeholder = {
                    Text(text = placeholder, color = MaterialTheme.colorScheme.background)
                },
            )
        }

        "Email" -> {
            OutlinedTextField(
                value = viewModel?.loginUiState?.emailSignUp ?: "",
                onValueChange = {viewModel?.onEmailSignupChange(email = it)},
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
            OutlinedTextField(
                value = viewModel?.loginUiState?.passwordSignUp ?: "",
                onValueChange = {viewModel?.onPasswordSignupChange(password = it)},
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

            OutlinedTextField(
                value = viewModel?.loginUiState?.confirmPasswordSignUp ?: "" ,
                onValueChange = {
                    viewModel?.onConfirmPasswordSignupChange(confirmPassword = it)
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun createLoginTextField(viewModel: LoginViewModel?= null, label: String, placeholder: String){

    when(label){
        "Email" -> {
            OutlinedTextField(
                value = viewModel?.loginUiState?.email ?: "",
                onValueChange = {viewModel?.onEmailChange(email = it)},
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
            OutlinedTextField(
                value = viewModel?.loginUiState?.password ?: "",
                onValueChange = {viewModel?.onPasswordChange(password = it)},
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

    }
}



