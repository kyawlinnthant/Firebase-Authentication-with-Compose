package mdy.klt.firebaseauthenticationwithcompose.auth.presentation.login.udf

sealed class LoginEvent {
    object NavigateToSignup : LoginEvent()
    object NavigateToPassword : LoginEvent()
    object NavigateToHome : LoginEvent()
    data class ShowSnack(val message: String) : LoginEvent()
}
