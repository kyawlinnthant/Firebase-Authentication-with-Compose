package mdy.klt.firebaseauthenticationwithcompose.auth.presentation.signup

import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import kotlinx.coroutines.flow.collectLatest
import mdy.klt.firebaseauthenticationwithcompose.auth.presentation.signup.udf.SignupAction
import mdy.klt.firebaseauthenticationwithcompose.auth.presentation.signup.udf.SignupEvent

@Composable
fun SignupScreen(
    navController: NavController
) {

}

@Composable
fun SignupView(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val vm: SignupViewModel = hiltViewModel()
    val state = vm.signupState.value
    val form = state.form
    val error = state.error
    val scaffoldState = rememberScaffoldState()
    LaunchedEffect(key1 = true) {
        vm.signupEvent.collectLatest {
            when (it) {
                SignupEvent.NavigateToHome -> {
                    // todo : navController navigate
                }
                SignupEvent.NavigateToLogin -> {
                    // todo : navController navigate
                }
                is SignupEvent.ShowSnack -> {
                    scaffoldState.snackbarHostState.showSnackbar(message = it.message)
                }
            }
        }
    }
    Scaffold(scaffoldState = scaffoldState) {
        SignupContent(
            emailValue = form.email,
            onEmailChanged = {
                vm.onAction(SignupAction.ChangeEmail(email = it.trim()))
            },
            onEmailCleared = { vm.onAction(SignupAction.ChangeEmail(email = "")) },
            emailHint = "Fill your email address",
            isEmailError = error.emailError,
            emailErrorMessage = "Correct your email address",
            passwordValue = form.password,
            onPasswordChanged = {
                vm.onAction(SignupAction.ChangePassword(password = it.trim()))
            },
            passwordHint = "Fill your password (8 to 12 length)",
            isPasswordError = error.passwordError,
            passwordErrorMessage = """Password must have 8 to 12 length and at least contain one capital letter, one small letter, one digit, one of "@#\$%^&+=!" """,
            confirmPasswordValue = form.confirmPassword,
            onConfirmPasswordChanged = {
                vm.onAction(SignupAction.ChangeConfirmPassword(confirmPassword = it.trim()))
            },
            confirmPasswordHint = "Fill your password again",
            isConfirmPasswordError = error.confirmPasswordError,
            confirmPasswordErrorMessage = "Confirm password must be identical with password!",
            onSignupClicked = {
                vm.onAction(SignupAction.ClickRegister)
            }
        )
    }
}