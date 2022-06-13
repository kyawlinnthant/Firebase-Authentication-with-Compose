package mdy.klt.firebaseauthenticationwithcompose.auth.presentation.login.udf

data class LoginState(
    val form: LoginForm = LoginForm(),
    val error: LoginError = LoginError(),
    val isLoading: Boolean = false,
)
