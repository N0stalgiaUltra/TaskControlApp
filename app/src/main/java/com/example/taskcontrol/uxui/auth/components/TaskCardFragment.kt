package com.example.taskcontrol.uxui.auth.components

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.taskcontrol.ui.theme.TaskControlTheme
import com.example.taskcontrol.uxui.auth.login.LoginViewModel
import com.example.taskcontrol.uxui.data.CardsState
import com.example.taskcontrol.uxui.data.UserCardsViewModel
import kotlinx.coroutines.Job

@Preview
@Composable
private fun PreviewTaskCard(){
    TaskControlTheme(true) {

    }
}

@Composable
fun TaskCard(cardsState: CardsState, userCardsViewModel: UserCardsViewModel, loginViewModel: LoginViewModel) {

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

                CreateButton(
                    text = "Remove",
                    color = Color.Red,
                    onClick = { userCardsViewModel.removeCard(cardsState.id) }
                )

                CreateButton(text = "Edit", color = Color.Yellow, onClick = {}
                )

                IconButton(
                    modifier = Modifier
                        .padding(5.dp),
                    onClick = {
                        when(cardsState.state.lowercase()){

                            "todo" -> {
                                userCardsViewModel.onChangeState("doing", cardsState.id)
                                Log.d("cards", "size ${userCardsViewModel.doingCards.size}")
                            }
                            "doing" -> {
                                userCardsViewModel.onChangeState("done", cardsState.id)
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


