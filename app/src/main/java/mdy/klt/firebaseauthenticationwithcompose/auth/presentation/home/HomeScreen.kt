package mdy.klt.firebaseauthenticationwithcompose.auth.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun HomeScreen(
    navController: NavController
){
    HomeView(navController = navController)
}

@Composable
fun HomeView(
    navController: NavController,
    modifier : Modifier = Modifier
){
    val vm : HomeViewModel = hiltViewModel()
    Surface {
        Column(modifier = modifier.fillMaxSize()) {
            Text(text = vm.user?.uid ?: "Empty id")
            Text(text = vm.user?.email ?: "Empty email")
        }
    }
}