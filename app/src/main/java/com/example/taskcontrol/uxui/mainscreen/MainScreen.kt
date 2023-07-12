package com.example.taskcontrol.uxui.mainscreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.taskcontrol.ui.theme.TaskControlTheme
import com.example.taskcontrol.uxui.auth.components.TaskCard
import com.example.taskcontrol.uxui.auth.login.LoginViewModel
import org.w3c.dom.Text
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import com.example.taskcontrol.R
import com.example.taskcontrol.pagerTab.pagerTabIndicatorOffset
import com.example.taskcontrol.uxui.auth.components.CreateCardAlert
import com.example.taskcontrol.uxui.data.CardsState
import com.example.taskcontrol.uxui.data.UserCardsViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import com.google.android.material.bottomnavigation.BottomNavigationView


@OptIn(ExperimentalMaterial3Api::class, ExperimentalPagerApi::class)
@Composable
fun MainScreen(onNavigateToLogin: ()-> Unit, viewModel: LoginViewModel){
    val context = LocalContext.current
    var selectedTab by remember { mutableStateOf(0) }
    val tabs = listOf("To do", "Doing", "Done")
    val stateUi = viewModel?.loginUiState
    val pagerState = rememberPagerState()
    val cardsViewModel = UserCardsViewModel()
    var openDialog by remember { mutableStateOf(false) }



    Scaffold(
        topBar = {

            TabRow(selectedTabIndex = selectedTab,
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
                            selected = selectedTab == index,
                            onClick = {selectedTab = index},
                            text = {
                                Text(text = title,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis)
                            }
                        )
                    }

                    IconButton(onClick = { /*TODO*/ }) {
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
            if(openDialog){
                CreateCardAlert(viewModel = cardsViewModel){
                    openDialog = false
                }
            }

            HorizontalPager(
                count = tabs.size,
                state = pagerState) {
                selectedTab ->

                when(selectedTab){
                    0 -> {
                        TodoScreen()}
                    1 -> {
                        DoingScreen()}
                }

                }
            }
            /*
            TaskCard(taskName = "Compor samba para o Salgueiro")
            TaskCard(taskName = "Terminar faculdade")
            TaskCard(taskName = "Conseguir Emprego como Android Developer")*/
        }
    }




//top bar

    //Box com Column contendo os cards

    //Botão para adicionar os cards (Scaffold)



@Preview
@Composable
private fun mainScreenPreview(){
    TaskControlTheme(darkTheme = true) {
        MainScreen({}, viewModel = LoginViewModel())
    }
}


@Composable
fun TodoScreen(){
    val viewModel = UserCardsViewModel()
    val dummiesCardList = DummyCardList()

    dummiesCardList.forEach {
        viewModel.addCard(it)
    }

    LazyColumn(modifier = Modifier.padding(16.dp)) {

        items(viewModel.todoCards){
            card -> TaskCard(taskName = card.title, id = card?.id, viewModel, "todo")
        }

    }
}

@Composable
fun DoingScreen(){
    val viewModel = UserCardsViewModel()
    val dummiesCardList = DummyCardList()

    dummiesCardList.forEach {
        viewModel.addCard(it)
    }

    LazyColumn(modifier = Modifier.padding(16.dp)) {

        items(viewModel.doingCards){
                card -> TaskCard(taskName = card.title, id = card?.id, viewModel, "doing")
        }

    }
}

private fun DummyCardList(): List<CardsState>{
    return listOf(
        CardsState("Testando os Cards", 1, "", "todo"),
        CardsState("Cards no TODO", 2, "", "todo"),
        CardsState("Card no Doing", 3, "", "doing"),
        CardsState("Outro Tipo", 4, "", "doing"),
        CardsState("Outro Tipo de card", 5, "", "doing")
    )

}

