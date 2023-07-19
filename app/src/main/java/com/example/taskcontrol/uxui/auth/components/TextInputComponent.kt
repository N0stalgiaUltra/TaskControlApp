package com.example.taskcontrol.uxui.auth.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults.textFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.example.taskcontrol.uxui.auth.forgetpassword.ForgetPasswordViewModel
import com.example.taskcontrol.uxui.auth.login.LoginViewModel
import com.example.taskcontrol.uxui.auth.register.RegisterViewModel

@Composable
fun <T>textInputFragment(label: String, placeholder: String,
                      userViewModel: T? = null) where T: ViewModel{

    CreateText(
        text = label.drop(2),
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier
    )

    when(label){
        "R_Username" -> createRegisterTextField(viewModel = userViewModel as? RegisterViewModel, label = "Username", placeholder = placeholder)
        "R_Email" -> createRegisterTextField(viewModel = userViewModel as? RegisterViewModel, label = "Email", placeholder = placeholder)
        "R_Password" -> createRegisterTextField(viewModel = userViewModel as? RegisterViewModel, label = "Password", placeholder = placeholder)
        "R_Confirm Password" -> createRegisterTextField(viewModel = userViewModel as? RegisterViewModel, label = "Confirm Password", placeholder = placeholder)
        "L_Email" -> createLoginTextField(viewModel = userViewModel as? LoginViewModel, label = "Email", placeholder = placeholder)
        "L_Password" -> createLoginTextField(viewModel = userViewModel as? LoginViewModel, label = "Password", placeholder = placeholder)
        "F_Email" -> createForgetPasswordTextField(viewModel = userViewModel as? ForgetPasswordViewModel, label = "Email", placeholder = placeholder)
    }
    Spacer(modifier = Modifier.height(8.dp))
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun createRegisterTextField(viewModel: RegisterViewModel?= null, label: String, placeholder: String){

    when(label){
        "Username" -> {
            OutlinedTextField(
                value = viewModel?.registerUiState?.usernameSignUp ?: "",
                onValueChange = {
                                    viewModel?.onUsernameSignupChange(username = it)
                                    print(viewModel?.registerUiState?.usernameSignUp ?: "nada ainda")
                                },
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
                value = viewModel?.registerUiState?.emailSignUp ?: "",
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
                value = viewModel?.registerUiState?.passwordSignUp ?: "",
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
                value = viewModel?.registerUiState?.confirmPasswordSignUp ?: "" ,
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun createForgetPasswordTextField(viewModel: ForgetPasswordViewModel?= null, label: String, placeholder: String){
    when(label){
        "Email" -> {
            OutlinedTextField(
                value = viewModel?.forgetUiState?.email.toString(),
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
    }
}



