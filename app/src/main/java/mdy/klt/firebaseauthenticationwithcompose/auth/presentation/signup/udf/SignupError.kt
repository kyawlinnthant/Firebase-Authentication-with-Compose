package mdy.klt.firebaseauthenticationwithcompose.auth.presentation.signup.udf

data class SignupError(
    val emailError: Boolean = false,
    val passwordError: Boolean = false,
    val confirmPasswordError: Boolean = false,
)
