package mdy.klt.firebaseauthenticationwithcompose.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import mdy.klt.firebaseauthenticationwithcompose.app.navigation.Destinations
import mdy.klt.firebaseauthenticationwithcompose.app.theme.FirebaseAuthenticationWithComposeTheme
import mdy.klt.firebaseauthenticationwithcompose.auth.presentation.forgotpassword.ForgotPasswordScreen
import mdy.klt.firebaseauthenticationwithcompose.auth.presentation.home.HomeScreen
import mdy.klt.firebaseauthenticationwithcompose.auth.presentation.login.LoginScreen
import mdy.klt.firebaseauthenticationwithcompose.auth.presentation.signup.SignupScreen
import mdy.klt.firebaseauthenticationwithcompose.auth.presentation.signup.SignupView

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirebaseAuthenticationWithComposeTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Destinations.LOGIN,
                ){
                    composable(route = Destinations.LOGIN){
                        LoginScreen(navController = navController)
                    }
                    composable(route = Destinations.SIGNUP){
                        SignupScreen(navController = navController)
                    }
                    composable(route = Destinations.FORGOT_PASSWORD){
                        ForgotPasswordScreen(navController = navController)
                    }
                    composable(route = Destinations.HOME){
                        HomeScreen(navController = navController)
                    }
                }
            }
        }
    }
}
