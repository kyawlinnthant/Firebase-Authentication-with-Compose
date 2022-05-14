package mdy.klt.firebaseauthenticationwithcompose.auth.presentation.login

import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun LoginScreen(
    navController: NavController
) {

}

@Composable
fun LoginView(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
        content = {

        }
    )
}