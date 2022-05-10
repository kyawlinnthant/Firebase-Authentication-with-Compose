package mdy.klt.firebaseauthenticationwithcompose.auth.presentation.signup.udf

data class SignupForm(
    val email : String = "",
    val password : String = "",
    val confirmPassword : String = "",
)
