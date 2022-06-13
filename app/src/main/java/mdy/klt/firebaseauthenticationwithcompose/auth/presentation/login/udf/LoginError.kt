package mdy.klt.firebaseauthenticationwithcompose.auth.presentation.login.udf

data class LoginError(
    val emailError: Boolean = false,
    val passwordError: Boolean = false,
)
