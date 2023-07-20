package com.example.taskcontrol.uxui.auth.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults.textFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
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

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
private fun createRegisterTextField(viewModel: RegisterViewModel?= null, label: String, placeholder: String){
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    when(label){
        "Username" -> {
            OutlinedTextField(
                value = viewModel?.registerUiState?.usernameSignUp ?: "",
                onValueChange = {
                                    viewModel?.onUsernameSignupChange(username = it)
                                    print(viewModel?.registerUiState?.usernameSignUp ?: "nada ainda")
                                },
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions (
                    onNext = {
                        focusManager.moveFocus(focusDirection = FocusDirection.Down)
                    }
                ),
                singleLine = true,
                colors = textFieldColors(
                    textColor = MaterialTheme.colorScheme.background,
                    containerColor = MaterialTheme.colorScheme.primary),
                placeholder = {
                    Text(text = placeholder, color = MaterialTheme.colorScheme.background)
                },
                modifier = Modifier.fillMaxWidth(),
            )}

        "Email" -> {
            OutlinedTextField(
                value = viewModel?.registerUiState?.emailSignUp ?: "",
                onValueChange = {viewModel?.onEmailSignupChange(email = it)},
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = {
                        focusManager.moveFocus(focusDirection = FocusDirection.Down)
                    }
                ),
                singleLine = true,
                colors = textFieldColors(
                    textColor = MaterialTheme.colorScheme.background,
                    containerColor = MaterialTheme.colorScheme.primary),
                placeholder = {
                    Text(text = placeholder, color = MaterialTheme.colorScheme.background)
                },
                modifier = Modifier.fillMaxWidth(),

            )}
        "Password" ->{
            OutlinedTextField(
                value = viewModel?.registerUiState?.passwordSignUp ?: "",
                onValueChange = {viewModel?.onPasswordSignupChange(password = it)},
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = {
                        focusManager.moveFocus(focusDirection = FocusDirection.Down)
                    }
                ),
                singleLine = true,
                colors = textFieldColors(
                    textColor = MaterialTheme.colorScheme.background,
                    containerColor = MaterialTheme.colorScheme.primary),
                placeholder = {
                    Text(text = placeholder, color = MaterialTheme.colorScheme.background)
                },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth())
        }
        "Confirm Password" ->{

            OutlinedTextField(
                value = viewModel?.registerUiState?.confirmPasswordSignUp ?: "",
                onValueChange = {viewModel?.onConfirmPasswordSignupChange(confirmPassword = it)},
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        keyboardController?.hide()
                    }
                ),
                singleLine = true,
                colors = textFieldColors(
                    textColor = MaterialTheme.colorScheme.background,
                    containerColor = MaterialTheme.colorScheme.primary),
                placeholder = {
                    Text(text = placeholder, color = MaterialTheme.colorScheme.background)
                },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth())
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
private fun createLoginTextField(viewModel: LoginViewModel?= null, label: String, placeholder: String){
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current
    when(label){
        "Email" -> {
            OutlinedTextField(
                value = viewModel?.loginUiState?.email ?: "",
                onValueChange = {viewModel?.onEmailChange(email = it)},
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = {
                        focusManager.moveFocus(focusDirection = FocusDirection.Down)
                    }
                ),
                singleLine = true,
                colors = textFieldColors(
                    textColor = MaterialTheme.colorScheme.background,
                    containerColor = MaterialTheme.colorScheme.primary),
                placeholder = {
                    Text(text = placeholder, color = MaterialTheme.colorScheme.background)
                },
                modifier = Modifier.fillMaxWidth(),
                )}
        "Password" ->{
            OutlinedTextField(
                value = viewModel?.loginUiState?.password ?: "",
                onValueChange = {viewModel?.onPasswordChange(password = it)},
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        keyboardController?.hide()
                    }
                ),
                singleLine = true,
                colors = textFieldColors(
                    textColor = MaterialTheme.colorScheme.background,
                    containerColor = MaterialTheme.colorScheme.primary),
                placeholder = {
                    Text(text = placeholder, color = MaterialTheme.colorScheme.background)
                },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth()
            )
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
private fun createForgetPasswordTextField(
    viewModel: ForgetPasswordViewModel?= null,
    label: String,
    placeholder: String){

    val keyboardController = LocalSoftwareKeyboardController.current
    when(label){
        "Email" -> {
            OutlinedTextField(
                value = viewModel?.forgetUiState?.email.toString(),
                onValueChange = {viewModel?.onEmailChange(email = it)},
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions {
                    keyboardController?.hide()
                },
                singleLine = true,
                colors = textFieldColors(
                    textColor = MaterialTheme.colorScheme.background,
                    containerColor = MaterialTheme.colorScheme.primary),
                placeholder = {
                    Text(text = placeholder, color = MaterialTheme.colorScheme.background)
                },
                modifier = Modifier.fillMaxWidth()
            )}
    }
}



