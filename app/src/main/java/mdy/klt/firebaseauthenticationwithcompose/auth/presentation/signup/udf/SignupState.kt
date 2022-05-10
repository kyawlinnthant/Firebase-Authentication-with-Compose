package mdy.klt.firebaseauthenticationwithcompose.auth.presentation.signup.udf

data class SignupState(
    val form: SignupForm = SignupForm(),
    val error: SignupError = SignupError(),
    val isLoading: Boolean = false,
)
