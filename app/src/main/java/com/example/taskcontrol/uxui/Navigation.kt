package com.example.taskcontrol.uxui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.taskcontrol.uxui.auth.forgetpassword.ForgetAccountScreen
import com.example.taskcontrol.uxui.auth.forgetpassword.ForgetPasswordViewModel
import com.example.taskcontrol.uxui.auth.login.LoginScreen
import com.example.taskcontrol.uxui.auth.login.LoginViewModel
import com.example.taskcontrol.uxui.auth.register.RegisterScreen
import com.example.taskcontrol.uxui.auth.register.RegisterViewModel
import com.example.taskcontrol.uxui.data.UserCardsViewModel
import com.example.taskcontrol.uxui.mainscreen.MainScreen
import kotlinx.coroutines.delay

@Composable
fun Navigation(
    userCardsViewModel: UserCardsViewModel,
    loginViewModel: LoginViewModel,
    registerViewModel: RegisterViewModel,
    forgetPasswordViewModel: ForgetPasswordViewModel){

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.splash_screen.route){

        composable(route = Screen.splash_screen.route){
            ShowSplashFragment()
            LaunchedEffect(true){
                delay(2000)
                navController.navigate(Screen.login_screen.route)
            }
        }

        composable(route = Screen.login_screen.route){
            LoginScreen(onNavigateToRegister = {
                navController.navigate(Screen.register_screen.route)},
            onNavigateToMain = {navController.navigate(Screen.main_screen.route)},
            onNavigateToForget = {navController.navigate(Screen.forget_screen.route)},
                loginViewModel, userCardsViewModel)
        }
        composable(route = Screen.register_screen.route){
            //RegisterScreen(viewModel, userValidationViewModel) antigo
            RegisterScreen(registerViewModel = registerViewModel,
                onNavigateToLogin = {
                    navController.navigate(Screen.login_screen.route)
                })//novo
        }
        composable(route = Screen.main_screen.route){
            MainScreen(
                onNavigateToLogin = {navController.navigate(Screen.login_screen.route)},
                loginViewModel, userCardsViewModel
            )
        }
        composable(route = Screen.forget_screen.route){
            ForgetAccountScreen(
                forgetPasswordViewModel,
                onNavigateToLogin = {navController.navigate(Screen.login_screen.route)})
        }
    }
}