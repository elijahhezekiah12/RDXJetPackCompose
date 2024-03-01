package com.example.rdxjetpackcompose.ui.theme.NavGraph

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.rdxjetpackcompose.ui.theme.ChoosePin.ChoosePinScreen
import com.example.rdxjetpackcompose.ui.theme.ConfirmPInScreen.ConfirmPinScreen
import com.example.rdxjetpackcompose.ui.theme.TermsOfService.TermsOfServiceScreen
import com.example.rdxjetpackcompose.ui.theme.credentialsScreen.CredentialsScreen
import com.example.rdxjetpackcompose.ui.theme.mainScreen.MainScreen
import com.example.rdxjetpackcompose.ui.theme.personalInfoScreen.PersonalInfoScreen
import com.example.rdxjetpackcompose.ui.theme.welcomeScreen.WelcomeScreen

enum class Screen {
    WELCOME_SCREEN,
    MAIN_SCREEN,
    CHOOSE_PIN,
    CONFIRM_PIN,
    CREDENTIALS_SCREEN,
    PERSONAL_INFO_SCREEN,
    TERMS_OF_SERVICE,
}
sealed class NavigationItem(val route: String) {
    object Welcome : NavigationItem(Screen.WELCOME_SCREEN.name)
    object Main : NavigationItem(Screen.MAIN_SCREEN.name)
    object choose_pin : NavigationItem(Screen.CHOOSE_PIN.name)
    object confirm_pin:NavigationItem(Screen.CONFIRM_PIN.name)
    object credentials_screen:NavigationItem(Screen.CREDENTIALS_SCREEN.name)
    object personal_info_screen:NavigationItem(Screen.PERSONAL_INFO_SCREEN.name)
    object terms_of_service:NavigationItem(Screen.TERMS_OF_SERVICE.name)
}

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    startDestination: String = NavigationItem.Main.route,

    ) {
    val navController = rememberNavController()
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(NavigationItem.Main.route) {
            MainScreen(navController)

        }
        composable(NavigationItem.Welcome.route) {
            WelcomeScreen(navController)
        }

        composable(NavigationItem.terms_of_service.route){
            TermsOfServiceScreen(navController)
        }

        composable(NavigationItem.credentials_screen.route){
             CredentialsScreen(navController)
        }

        composable(NavigationItem.personal_info_screen.route){
            PersonalInfoScreen(navController)
        }

        composable(NavigationItem.choose_pin.route
        ){
            ChoosePinScreen(navController)
        }

        composable(NavigationItem.confirm_pin.route+"/{pin}",
            arguments = listOf(navArgument("pin") { type = NavType.StringType })
            ){ backStackEntry ->
             ConfirmPinScreen(navController,
             chosenPin = backStackEntry.arguments?.getString("pin") ?: ""
             )
        }

    }
}