package mdy.klt.firebaseauthenticationwithcompose.auth.presentation.login

import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import kotlinx.coroutines.flow.collectLatest
import mdy.klt.firebaseauthenticationwithcompose.app.navigation.Destinations
import mdy.klt.firebaseauthenticationwithcompose.auth.presentation.login.udf.LoginAction
import mdy.klt.firebaseauthenticationwithcompose.auth.presentation.login.udf.LoginEvent

@Composable
fun LoginScreen(
    navController: NavController
) {
    LoginView(navController = navController)
}

@Composable
fun LoginView(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val vm: LoginViewModel = hiltViewModel()
    val isLoading = vm.loginState.value.isLoading
    val form = vm.loginState.value.form
    val error = vm.loginState.value.error

    val scaffoldState = rememberScaffoldState()

    LaunchedEffect(key1 = true){
        vm.loginEvent.collectLatest {
            when (it) {
                LoginEvent.NavigateToHome -> {
                    navController.navigate(route = Destinations.HOME)
                }
                LoginEvent.NavigateToPassword -> {
                    navController.navigate(route = Destinations.FORGOT_PASSWORD)
                }
                LoginEvent.NavigateToSignup -> {
                    navController.navigate(route = Destinations.SIGNUP)
                }
                is LoginEvent.ShowSnack -> {
                    scaffoldState.snackbarHostState.showSnackbar(message = it.message)
                }
            }
        }
    }


    Scaffold(
        scaffoldState = scaffoldState,
        content = {
            LoginContent(
                emailValue = form.email,
                onEmailChanged = {
                    vm.onAction(LoginAction.ChangeEmail(email = it))
                },
                onEmailCleared = {
                    vm.onAction(LoginAction.ChangeEmail(email = ""))
                },
                emailHint = "Fill email",
                isEmailError = error.emailError,
                emailErrorMessage = "Fill correct email",
                passwordValue = form.password,
                onPasswordChanged = {
                    vm.onAction(LoginAction.ChangePassword(password = it))
                },
                passwordHint = "Fill password",
                isPasswordError = error.passwordError,
                passwordErrorMessage = "Fill correct password",
                onLoginClicked = {
                    vm.onAction(LoginAction.ClickLogin)
                },
                onPasswordClicked = {
                    vm.onAction(LoginAction.ClickPassword)
                },
                onSignupClicked = {
                    vm.onAction(LoginAction.ClickSignup)
                })
        }
    )
}