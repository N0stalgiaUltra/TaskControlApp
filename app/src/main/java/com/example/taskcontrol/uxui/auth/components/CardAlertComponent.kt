package com.example.taskcontrol.uxui.auth.components

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.taskcontrol.uxui.auth.login.LoginViewModel
import com.example.taskcontrol.uxui.data.CardsState
import com.example.taskcontrol.uxui.data.UserCardsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateCardAlert(userViewModel: LoginViewModel,
                    cardViewModel: UserCardsViewModel,
                    onDismiss: ()-> Unit){
    var title by remember { mutableStateOf("") }
    val context = LocalContext.current

    AlertDialog(
        onDismissRequest = { onDismiss() },

        confirmButton = {
            ButtonComponent(onClick = {
                val newCard = CardsState(
                    title = title,
                    id = "",
                    state = "todo",
                    userAttached = userViewModel.loginUiState.userUUID
                )

                cardViewModel.addCard(newCard)
                onDismiss()
            }, text = "Add Card")
        },

        dismissButton = {
            ButtonComponent(onClick = { onDismiss() }, text = "Fechar")
        },
        title = {
            Text(
                text = "Create Button",
                color = MaterialTheme.colorScheme.primary
            )
        },
        text = {
            Column(modifier = Modifier.padding(5.dp)) {
                TextField(
                    value = title,
                    onValueChange = {
                        title = it
                    },
                    placeholder = {
                        Text(
                            "What are you up to?",
                            color = MaterialTheme.colorScheme.primary
                        )
                    })

            }

        },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateCardAlert(card: CardsState,
                    cardViewModel: UserCardsViewModel,
                    onDismiss: ()-> Unit){
    var title by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = { onDismiss() },

        confirmButton = {
            ButtonComponent(onClick = {

                cardViewModel.onChangeCardTitle(title, card.id)
                onDismiss()
            }, text = "Edit Card")
        },

        dismissButton = {
            ButtonComponent(onClick = { onDismiss() }, text = "Fechar")
        },
        title = {
            Text(
                text = "Create Button",
                color = MaterialTheme.colorScheme.primary
            )
        },
        text = {
            Column(modifier = Modifier.padding(5.dp)) {
                TextField(
                    value = title,
                    onValueChange = {
                        title = it
                    },
                    placeholder = {
                        Text(
                            "Edit your title",
                            color = MaterialTheme.colorScheme.primary
                        )
                    })

            }

        },
    )
}



