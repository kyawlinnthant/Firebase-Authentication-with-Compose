package mdy.klt.firebaseauthenticationwithcompose.auth.presentation.signup.udf

sealed class SignupEvent {
    object NavigateToLogin : SignupEvent()
    object NavigateToHome : SignupEvent()
}
