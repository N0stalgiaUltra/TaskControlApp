package com.example.taskcontrol.uxui.mainscreen

import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme

import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.taskcontrol.ui.theme.TaskControlTheme
import com.example.taskcontrol.uxui.auth.components.TaskCard
import com.example.taskcontrol.uxui.auth.login.LoginViewModel

import androidx.compose.ui.text.style.TextOverflow
import com.example.taskcontrol.R
import com.example.taskcontrol.pagerTab.pagerTabIndicatorOffset
import com.example.taskcontrol.uxui.auth.components.CreateCardAlert
import com.example.taskcontrol.uxui.data.UserCardsViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class, ExperimentalPagerApi::class)
@Composable
fun MainScreen(onNavigateToLogin: ()-> Unit,
               loginViewModel: LoginViewModel,
               cardsViewModel: UserCardsViewModel){
    val context = LocalContext.current
    val tabs = listOf("To do", "Doing", "Done")
    val stateUi = loginViewModel?.loginUiState
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()
    var openDialog by remember { mutableStateOf(false) }

    cardsViewModel.getCards(stateUi?.userUUID.toString())


    Scaffold(
        topBar = {

            TabRow(selectedTabIndex = pagerState.currentPage,
                modifier = Modifier.padding(bottom = 16.dp),
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.background,
                indicator = {
                            tabPositions ->
                    TabRowDefaults.Indicator(

                        Modifier.pagerTabIndicatorOffset(
                            pagerState,
                            tabPositions
                        ),
                        color = MaterialTheme.colorScheme.background
                    )
                },
                tabs = {
                    tabs.forEachIndexed{
                        index, title -> Tab(
                            selected = pagerState.currentPage == index,
                            onClick = {
                                coroutineScope.launch {
                                    pagerState.animateScrollToPage(index)
                                }
                            },
                            text = {
                                Text(text = title,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis)
                            }
                        )
                    }

                    IconButton(onClick = {
                            loginViewModel.logoutUser(context)
                            if(!loginViewModel.hasUser)
                                onNavigateToLogin()
                    }) {
                        Icon(painter = painterResource(id = R.drawable.baseline_logout_24),
                            contentDescription = "logout button")
                    }
                })

         },
        floatingActionButton = {
            FloatingActionButton(
                containerColor = MaterialTheme.colorScheme.primary,
                onClick = {
                    openDialog = true
                }
                ) {
                FabPosition.End
                Icon(imageVector = Icons.Filled.Add, contentDescription = "FAB icon")
            }
        },
    )
    {
        //isso é feito no content para evitar problemas de layout
        paddingValues -> Column(modifier = Modifier.padding(paddingValues)) {


            HorizontalPager(
                count = tabs.size,
                state = pagerState) {
                    selectedTab ->
                    when(selectedTab){
                        0 -> {
                                CardsScreen(cardsViewModel, loginViewModel, "todo")
                            }
                        1 -> {
                            CardsScreen(cardsViewModel, loginViewModel, "doing")}
                        2 -> {
                            CardsScreen(cardsViewModel, loginViewModel, "done")
                        }
                    }

                }
            }

            if(openDialog){
                CreateCardAlert(loginViewModel, cardsViewModel){
                    openDialog = false
                }
            }

        }
    }




//top bar

    //Box com Column contendo os cards

    //Botão para adicionar os cards (Scaffold)



@Preview
@Composable
private fun mainScreenPreview(){
    TaskControlTheme(darkTheme = true) {
        //MainScreen({}, viewModel = LoginViewModel())
    }
}


@Composable
fun CardsScreen(cardsViewModel:UserCardsViewModel, loginViewModel: LoginViewModel, state: String){
    LazyColumn(modifier = Modifier.padding(16.dp)) {

        when(state){
            "todo" -> {
                    items(cardsViewModel.todoCards){
                    card -> TaskCard(card, cardsViewModel, loginViewModel)
                    }
            }

            "doing" -> {
                    items(cardsViewModel.doingCards){
                    card -> TaskCard(card, cardsViewModel, loginViewModel)
                    }
            }

            "done" -> {
                    items(cardsViewModel.doneCards){
                    card -> TaskCard(card, cardsViewModel, loginViewModel)
                    }
            }
        }


    }
}
