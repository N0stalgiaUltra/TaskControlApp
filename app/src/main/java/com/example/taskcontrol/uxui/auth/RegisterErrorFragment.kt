package com.example.taskcontrol.uxui.auth

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import arrow.core.left
import com.example.taskcontrol.uxui.data.UserValidationViewModel
import com.example.taskcontrol.uxui.data.UserViewModel

@Composable
fun CheckErrors(userViewModel: UserViewModel, userError: UserValidationViewModel): Boolean{
    TextError(text = userError.verifyEmail(userViewModel.user.email))
    TextError(text = userError.verifyPassword(userViewModel.user.password))
    TextError(text = userError.verifyConfirmPassword(userViewModel.user.password, userViewModel.confirmPassword))

    return(userError.verifyEmail(userViewModel.user.email).isEmpty() &&
        userError.verifyPassword(userViewModel.user.password).isEmpty() &&
        userError.verifyConfirmPassword(userViewModel.user.password,
            userViewModel.confirmPassword).isEmpty())

}


@Composable
private fun TextError(text: String){
    Spacer(modifier = Modifier.padding(2.dp))
    if(text.isEmpty()){
        Text(text = "", color = Color.Transparent)
    }
    else{
        Text(text = "$text", color = Color.Red)
    }
}
