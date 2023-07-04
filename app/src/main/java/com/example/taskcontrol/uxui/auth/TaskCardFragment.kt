package com.example.taskcontrol.uxui.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskcontrol.ui.theme.TaskControlTheme

@Preview
@Composable
private fun PreviewTaskCard(){
    TaskControlTheme(true) {
        Column() {
            TaskCard("Teste de Card")
            TaskCard("Teste de Card")
            TaskCard("Teste de Card")
        }

    }
}

@Composable
fun TaskCard(taskName: String) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.background)
    ){
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)) {

            Text(
                text = taskName,
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth().padding(5.dp, 15.dp)
            )

            Row(modifier = Modifier.fillMaxWidth()){

                CreateButton(text = "Remove", color = Color.Red)
                CreateButton(text = "Edit", color = Color.Yellow)
                CreateButton(text = "Details", color = Color.White)

                    IconButton(
                        modifier = Modifier
                            .padding(5.dp),
                        onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Filled.ArrowForward,
                            contentDescription = "Arrow Icon")
                }
            }

        }
    }


}