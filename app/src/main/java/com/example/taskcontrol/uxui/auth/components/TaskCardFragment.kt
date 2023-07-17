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
import com.example.taskcontrol.uxui.data.UserCardsViewModel

@Preview
@Composable
private fun PreviewTaskCard(){
    TaskControlTheme(true) {
        Column() {

        }

    }
}

@Composable
fun TaskCard(taskName: String, id: String, viewModel: UserCardsViewModel, state : String) {

    val card_id = id

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
                text = taskName,
                color = MaterialTheme.colorScheme.background,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp, 15.dp)
            )

            Row(modifier = Modifier.fillMaxWidth()){

                CreateButton(text = "Remove", color = Color.Red)
                CreateButton(text = "Edit", color = Color.Yellow)

                IconButton(
                    modifier = Modifier
                        .padding(5.dp),
                    onClick = {
                        when(state.lowercase()){

                            "todo" -> { viewModel.onChangeState("doing", card_id)
                                Log.d("cards", "size ${viewModel.doingCards.size}")
                            }
                            "doing" -> { viewModel.onChangeState("done", card_id)
                                Log.d("cards", "size ${viewModel.doneCards.size}")
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
// Em qual aba estamos?
// para qual aba posso ir?


