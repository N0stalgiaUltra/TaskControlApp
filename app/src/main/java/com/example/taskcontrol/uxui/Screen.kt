package com.example.taskcontrol.uxui

sealed class Screen(val route: String){
    object splash_screen : Screen("splash_screen")
    object main_screen : Screen("main_screen")
    object login_screen : Screen("login_screen")
    object register_screen : Screen("register_screen")
    object forget_screen : Screen("forget_screen")
}
