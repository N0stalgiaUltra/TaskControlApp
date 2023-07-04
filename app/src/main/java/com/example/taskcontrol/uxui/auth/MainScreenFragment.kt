package com.example.taskcontrol.uxui.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.Button
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.taskcontrol.ui.theme.TaskControlTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(onNavigateToLogin: ()-> Unit){

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.largeTopAppBarColors(MaterialTheme.colorScheme.primary),
                title = {
                        Row(modifier = Modifier.fillMaxWidth()){
                            Text(text = "To do",
                                color = MaterialTheme.colorScheme.background,
                                modifier = Modifier
                                    .padding(16.dp)
                                    .clickable
                                    {
                                        /*TODO*/
                                    }
                            )
                            Text(text = "Doing",
                                color = MaterialTheme.colorScheme.background
                                ,
                                modifier = Modifier
                                    .padding(16.dp)
                                    .clickable
                                    {
                                        /*TODO*/
                                    }
                            )

                            Text(text = "Done",
                                color = MaterialTheme.colorScheme.background
                                ,
                                modifier = Modifier
                                    .padding(16.dp)
                                    .clickable
                                    {
                                        /*TODO*/
                                    }
                            )

                            IconButton(onClick = { /*TODO: Implementar Logout*/
                                onNavigateToLogin()
                            }) {
                                Icon(
                                    imageVector = Icons.Filled.ExitToApp,
                                    contentDescription = "LogoutIcon",
                                    tint = MaterialTheme.colorScheme.background,
                                    modifier = Modifier.padding(top = 16.dp, start = 10.dp)
                                )
                            }
                        }


                        },

                )
            }, floatingActionButton = {
                FloatingActionButton(
                    containerColor = MaterialTheme.colorScheme.primary,
                    onClick = { /*TODO*/ }) {
                    FabPosition.End
                    Icon(imageVector = Icons.Filled.Add, contentDescription = "FAB icon")
                }
        },
        )
    {
        //isso é feito no content para evitar problemas de layout
        paddingValues -> Column(modifier = Modifier.padding(paddingValues)) {
            TaskCard(taskName = "Compor samba para o Salgueiro")
            TaskCard(taskName = "Terminar faculdade")
            TaskCard(taskName = "Conseguir Emprego como Android Developer")
        }
    }

    
    //top bar

    //Box com Column contendo os cards

    //Botão para adicionar os cards (Scaffold)

}

@Preview
@Composable
private fun mainScreenPreview(){
    TaskControlTheme(darkTheme = true) {
        MainScreen({})
    }
}