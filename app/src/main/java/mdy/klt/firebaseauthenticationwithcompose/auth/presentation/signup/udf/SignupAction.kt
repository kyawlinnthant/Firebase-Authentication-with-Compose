package mdy.klt.firebaseauthenticationwithcompose.auth.presentation.signup.udf

sealed class SignupAction {
    object ClickRegister : SignupAction()
    object ClickLogin : SignupAction()
    data class ChangeUsername(val name: String) : SignupAction()
    data class ChangePassword(val password: String) : SignupAction()
    data class ChangeConfirmPassword(val confirmPassword: String) : SignupAction()
}
