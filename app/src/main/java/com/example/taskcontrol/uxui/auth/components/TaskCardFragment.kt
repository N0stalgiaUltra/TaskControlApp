package com.example.taskcontrol.uxui.auth.components

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.taskcontrol.ui.theme.TaskControlTheme
import com.example.taskcontrol.uxui.auth.login.LoginViewModel
import com.example.taskcontrol.uxui.data.CardsState
import com.example.taskcontrol.uxui.data.UserCardsViewModel

@Preview
@Composable
private fun PreviewTaskCard(){
    TaskControlTheme(true) {
        TaskCard(cardsState = CardsState(title = "Teste de card",
            id = "", "", "doing")
            , userCardsViewModel = UserCardsViewModel())
    }
}

@Composable
fun TaskCard(cardsState: CardsState, userCardsViewModel: UserCardsViewModel) {
    var openDialog by remember { mutableStateOf(false) }
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primary)
    ){
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)) {

            Text(
                text = cardsState.title,
                color = MaterialTheme.colorScheme.background,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp, 15.dp)
            )

            Row(modifier = Modifier.fillMaxWidth()){

                if(cardsState.state != "todo"){
                    IconButton(
                        modifier = Modifier
                            .padding(5.dp),
                        onClick = {
                            when(cardsState.state.lowercase()){

                                "doing" -> {
                                    userCardsViewModel.onChangeCardState("todo", cardsState.id)
                                    Log.d("cards", "size ${userCardsViewModel.doingCards.size}")
                                }
                                "done" -> {
                                    userCardsViewModel.onChangeCardState("doing", cardsState.id)
                                    Log.d("cards", "size ${userCardsViewModel.doneCards.size}")
                                }


                            }

                        }){
                        Icon(imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Arrow Icon")}
                }

                CreateButton(
                    text = "Remove",
                    color = Color.Red,
                    onClick = { userCardsViewModel.removeCard(cardsState.id) }
                )

                CreateButton(text = "Edit", color = Color.Yellow, onClick = {
                    openDialog = true }
                )

                if(cardsState.state != "done"){
                    IconButton(
                        modifier = Modifier
                            .padding(5.dp),
                        onClick = {
                            when(cardsState.state.lowercase()){

                                "todo" -> {
                                    userCardsViewModel.onChangeCardState("doing", cardsState.id)
                                    Log.d("cards", "size ${userCardsViewModel.doingCards.size}")
                                }
                                "doing" -> {
                                    userCardsViewModel.onChangeCardState("done", cardsState.id)
                                    Log.d("cards", "size ${userCardsViewModel.doneCards.size}")
                                }


                            }

                        }) {
                        Icon(imageVector = Icons.Filled.ArrowForward,
                            contentDescription = "Arrow Icon")
                    }
                }

            }

        }
    }

    if(openDialog){
        CreateCardAlert(card = cardsState, cardViewModel = userCardsViewModel) {
            openDialog = false
        }
    }


}


