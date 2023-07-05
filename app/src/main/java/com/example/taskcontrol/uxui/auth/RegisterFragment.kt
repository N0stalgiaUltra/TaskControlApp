package com.example.taskcontrol.uxui.auth

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskcontrol.uxui.data.UserValidationViewModel
import com.example.taskcontrol.uxui.data.UserViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(viewModel: UserViewModel, userValidationViewModel: UserValidationViewModel){

    Scaffold(
        topBar = { TopAppBarrComponent(text = "Register")}
    ) {
        paddingValues -> Modifier.padding(paddingValues)
        RegisterScreenComponents(viewModel, userValidationViewModel)

    }

}

@Preview
@Composable
fun PreviewRegisterScreen(){
    RegisterScreen(viewModel = UserViewModel(), userValidationViewModel = UserValidationViewModel())
}

@Composable
private fun RegisterScreenComponents(viewModel: UserViewModel,
                                     userValidationViewModel: UserValidationViewModel){

    Box(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
        , contentAlignment = Alignment.Center
    ) {
        Column {

            textInputFragment(label = "Username", placeholder = "Create Username", viewModel)
            textInputFragment(label = "Email", placeholder = "Create Email", viewModel)
            textInputFragment(label = "Password", placeholder = "Create Password", viewModel)
            textInputFragment(label = "Confirm Password", placeholder = "Confirm Password", viewModel)
            Spacer(modifier = Modifier.height(10.dp))

            ButtonComponent(onClick = { /*TODO: Passar valores do ViewModel para o Firebase*/ },
                text = "Create Account")
            Column(Modifier.padding(10.dp)) {
                CheckErrors(viewModel, userValidationViewModel)
            }
        }
    }
}